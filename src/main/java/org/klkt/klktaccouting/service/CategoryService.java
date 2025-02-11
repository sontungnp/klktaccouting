package org.klkt.klktaccouting.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.klkt.klktaccouting.model.KMetadata;
import org.klkt.klktaccouting.repository.CategoryMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CategoryMetadataRepository categoryMetadataRepository;

    public KMetadata getMetadataByTableName(String tableName) {
        return categoryMetadataRepository.findByTableName(tableName)
                .orElseThrow(() -> new RuntimeException("Table not found"));
    }

    public JsonNode getAllTables() {
        ObjectMapper mapper = new ObjectMapper(); // Tạo ObjectMapper để làm việc với JSON

        // Tạo một ArrayNode để chứa các đối tượng JSON
        ArrayNode arrayNode = mapper.createArrayNode();

        // Sử dụng stream() để chuyển đổi danh sách CategoryMetadata
        categoryMetadataRepository.findAll()
                .stream()
                .map(metadata -> {
                    // Tạo ObjectNode cho mỗi phần tử metadata
                    return mapper.createObjectNode()
                            .put("tableName", metadata.getTableName())
                            .put("tableDesc", metadata.getTableDesc());
                })
                .forEach(arrayNode::add); // Thêm mỗi ObjectNode vào ArrayNode

        return arrayNode; // Trả về JsonNode
    }

    public Map<String, List<Map<String, Object>>> getDropdownDataFromTable(String tableName)
            throws Exception {

        KMetadata metadata = getMetadataByTableName(tableName);
        ObjectMapper objectMapper = new ObjectMapper();
        // Parse searchable_columns từ cột JSON
        List<Map<String, Object>> dropDownColumns = new ObjectMapper().readValue(metadata.getColumnDropdownSources(), List.class);

        // Lấy giá trị dropdown từ các bảng khác nhau
        Map<String, List<Map<String, Object>>> dropdownValues = new HashMap<>();
        for (Map<String, Object> column : dropDownColumns) {
            if ("dropdown".equals(column.get("type"))) {
                String sourceTable = (String) column.get("source_table");
                String valueColumn = (String) column.get("value_column");
                String labelColumn = (String) column.get("label_column");
                String query = String.format("SELECT %s as id, %s as name FROM %s", valueColumn, labelColumn, sourceTable);
                List<Map<String, Object>> dropdownData = jdbcTemplate.queryForList(query);
                dropdownValues.put((String) column.get("name"), dropdownData);
            }
        }

        return dropdownValues;
    }

    public List<Map<String, Object>> getDropdownDataFromTable(String tableName, String valueColumn, String labelColumn) {
        String query = String.format("SELECT %s, %s FROM %s", valueColumn, labelColumn, tableName);
        return jdbcTemplate.queryForList(query);
    }

    // Lấy dữ liệu dropdown từ các bảng liên quan
    public Map<String, List<Map<String, Object>>> getDropdownData(String tableName)
            throws Exception {
        KMetadata metadata = getMetadataByTableName(tableName);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode dropdownSources = objectMapper.readTree(metadata.getColumnDropdownSources());
        Map<String, List<Map<String, Object>>> dropdownValues = new HashMap<>();

        dropdownSources.fields().forEachRemaining(entry -> {
            String columnName = entry.getKey();
            String sourceTable = entry.getValue().asText();

            String query = "SELECT id, name FROM " + sourceTable;
            List<Map<String, Object>> values = jdbcTemplate.queryForList(query);
            dropdownValues.put(columnName, values);
        });

        return dropdownValues;
    }

    // Tạo mới record
    public int createRecord(String tableName, Map<String, Object> data) {
        StringBuilder queryBuilder = new StringBuilder("INSERT INTO ");
        queryBuilder.append(tableName).append(" (");
        StringBuilder valueBuilder = new StringBuilder("VALUES (");

        data.forEach((column, value) -> {
            queryBuilder.append(column).append(",");
            valueBuilder.append("'").append(value).append("',");
        });

        queryBuilder.setLength(queryBuilder.length() - 1);
        valueBuilder.setLength(valueBuilder.length() - 1);

        queryBuilder.append(") ").append(valueBuilder).append(")");
        return jdbcTemplate.update(queryBuilder.toString());
    }

    // Hàm tìm kiếm dựa trên điều kiện động
    public List<Map<String, Object>> searchRecords(String tableName, Map<String, Object> conditions) {
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM ").append(tableName).append(" WHERE 1=1");

        conditions.forEach((column, value) -> {
            queryBuilder.append(" AND ").append(column).append(" ILIKE '%").append(value).append("%'");
        });

        return jdbcTemplate.queryForList(queryBuilder.toString());
    }

    // Hàm tìm kiếm dựa trên điều kiện động và cột cấu hình cho phép tìm kiếm
    public List<Map<String, Object>> searchRecords(String tableName, String searchQuery)
            throws Exception {
        KMetadata metadata = getMetadataByTableName(tableName);
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> listColumnsSearch
                = objectMapper.readValue(metadata.getColumnSearchs(), new TypeReference<>() {
        });

        String sql = "SELECT * FROM " + tableName + " WHERE 1=1";// name ILIKE ?";
        List<String> lstQuery = new ArrayList<>();

        if (listColumnsSearch != null && !listColumnsSearch.isEmpty()) {
            sql += " AND (";
            for (int i = 0; i < listColumnsSearch.size(); i++) {
                String column = listColumnsSearch.get(i);
                // Thêm điều kiện ILIKE với cột tương ứng
                sql += column + " ILIKE ?";

                // Thêm từ khóa OR giữa các điều kiện, trừ điều kiện cuối cùng
                if (i < listColumnsSearch.size() - 1) {
                    sql += " OR ";
                }
                lstQuery.add("%" + searchQuery + "%");
            }
            sql += ")"; // Đóng ngoặc sau các điều kiện OR

        }

        return jdbcTemplate.queryForList(sql, (Object[]) lstQuery.toArray(new String[0]));
    }

    // Lấy tất cả record
    public List<Map<String, Object>> getAllRecords(String tableName) {
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    // Update record
    public int updateRecord(String tableName, Map<String, Object> data, Long id) {
        StringBuilder queryBuilder = new StringBuilder("UPDATE ").append(tableName).append(" SET ");

        data.forEach((column, value) -> {
            queryBuilder.append(column).append(" = '").append(value).append("',");
        });

        queryBuilder.setLength(queryBuilder.length() - 1);
        queryBuilder.append(" WHERE id = ?");
        return jdbcTemplate.update(queryBuilder.toString(), id);
    }

    public int updateRecord(String tableName, Map<String, Object> data)
            throws Exception {
        KMetadata metadata = getMetadataByTableName(tableName);
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> primaryKeys
                = objectMapper.readValue(metadata.getColumnPrimarys(), new TypeReference<>() {
        });
        // Xây dựng câu truy vấn `UPDATE`
        StringBuilder queryBuilder = new StringBuilder("UPDATE " + tableName + " SET ");
        List<Object> params = new ArrayList<>();

        // Thêm các cột cần cập nhật
        data.forEach((key, value) -> {
            if (key != "primaryKeys") {
                if (!primaryKeys.contains(key)) { // Bỏ qua primary keys
//                    queryBuilder.append(key).append(" = ?, ");
//                    params.add(value);
                    if (value !=null) {
                        queryBuilder.append(key).append(" = '").append(value).append("',");
                    } else {
                        queryBuilder.append(key).append(" = ").append("null").append(",");
                    }
                }
            }
        });
        // Xóa dấu phẩy cuối cùng và thêm WHERE cho primary keys
//        queryBuilder.deleteCharAt(queryBuilder.length() - 2);
        queryBuilder.setLength(queryBuilder.length() - 1);
        queryBuilder.append(" WHERE ");
        primaryKeys.forEach(primaryKey -> {
            queryBuilder.append(primaryKey).append(" = ? AND ");
            params.add(data.get(primaryKey));
        });

        // Xóa " AND " cuối cùng
        queryBuilder.delete(queryBuilder.length() - 5, queryBuilder.length());

        // Thực thi truy vấn
        int r = jdbcTemplate.update(queryBuilder.toString(), params.toArray());
        return r;
    }

    // Xóa record
    public int deleteRecord(String tableName, Long id) {
        String query = "DELETE FROM " + tableName + " WHERE id = ?";
        return jdbcTemplate.update(query, id);
    }

    // Xóa record
    public int deleteRecord(String tableName, Map<String, Object> primaryKeyValues)
            throws Exception {
        KMetadata metadata = getMetadataByTableName(tableName);
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> primaryKeys
                = objectMapper.readValue(metadata.getColumnPrimarys(), new TypeReference<>() {
        });

        // Xây dựng câu truy vấn `DELETE`
        StringBuilder queryBuilder = new StringBuilder("DELETE FROM " + tableName + " WHERE ");
        List<Object> params = new ArrayList<>();

        primaryKeys.forEach(primaryKey -> {
            queryBuilder.append(primaryKey).append(" = ? AND ");
            params.add(primaryKeyValues.get(primaryKey));
        });

        // Xóa " AND " cuối cùng
        queryBuilder.delete(queryBuilder.length() - 5, queryBuilder.length());

        // Thực thi truy vấn
        int r = jdbcTemplate.update(queryBuilder.toString(), params.toArray());

        return r;

    }
}

