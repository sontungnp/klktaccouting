package org.klkt.klktaccouting.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.klkt.klktaccouting.model.KMetadata;
import org.klkt.klktaccouting.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/metadata/{tableName}")
    public ResponseEntity<Map<String, Object>> getMetadata(@PathVariable String tableName) throws Exception {

        Map<String, Object> response = new HashMap<>();
        KMetadata metadata = categoryService.getMetadataByTableName(tableName);

        // Khởi tạo ObjectMapper để phân tích cú pháp JSON
        ObjectMapper objectMapper = new ObjectMapper();

        // Chuyển đổi các trường từ chuỗi JSON sang đối tượng JSON
        JsonNode columnsJson = objectMapper.readTree(metadata.getColumns());
        JsonNode columnTypesJson = objectMapper.readTree(metadata.getColumnTypes());
        JsonNode columnValidationsJson = objectMapper.readTree(metadata.getColumnValidations());
        JsonNode columnDropdownSourcesJson = objectMapper.readTree(metadata.getColumnDropdownSources());
        JsonNode columnSearch = objectMapper.readTree(metadata.getColumnSearchs());
        JsonNode columnPrimary = objectMapper.readTree(metadata.getColumnPrimarys());
        // Thêm các đối tượng JSON vào metadata
        Map<String, Object> metadataMap = new HashMap<>();
        metadataMap.put("id", metadata.getId());
        metadataMap.put("tableName", metadata.getTableName());
        metadataMap.put("columns", columnsJson);
        metadataMap.put("columnTypes", columnTypesJson);
        metadataMap.put("columnValidations", columnValidationsJson);
        metadataMap.put("columnDropdownSources", columnDropdownSourcesJson);
        metadataMap.put("columnSearchs", columnSearch);
        metadataMap.put("columnPrimarys", columnPrimary);
        // Thêm metadata vào response
        response.put("metadata", metadataMap);

        // Lấy dropdown list:
        Map<String, List<Map<String, Object>>> dropdownValues
                = categoryService.getDropdownDataFromTable(tableName);
        //categoryService.getDropdownData(tableName);
        response.put("dropdownValues", dropdownValues);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-tables")
    public ResponseEntity<JsonNode> getAllTables() {
        JsonNode tableMap = categoryService.getAllTables();
        return ResponseEntity.ok(tableMap);
    }


    // Tạo mới record
    @PostMapping("/create/{tableName}")
    public ResponseEntity<String> createRecord(@PathVariable String tableName, @RequestBody Map<String, Object> data) {
        int result = categoryService.createRecord(tableName, data);
        return result > 0 ? ResponseEntity.ok("Created") : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
    }


    @PostMapping("/search/{tableName}")
    public ResponseEntity<List<Map<String, Object>>> searchRecords(@PathVariable String tableName, @RequestBody Map<String, String> conditions)
            throws Exception {
        String query = conditions.get("query");
        List<Map<String, Object>> results = categoryService.searchRecords(tableName, query);
        return ResponseEntity.ok(results);
    }

    // Lấy tất cả record
    @GetMapping("/get-all/{tableName}")
    public ResponseEntity<List<Map<String, Object>>> getAllRecords(@PathVariable String tableName) {
        List<Map<String, Object>> results = categoryService.getAllRecords(tableName);
        return ResponseEntity.ok(results);
    }

    // Update record
    @PutMapping("/update/{tableName}/{id}")
    public ResponseEntity<String> updateRecord(@PathVariable String tableName, @PathVariable Long id, @RequestBody Map<String, Object> data) {
        int result = categoryService.updateRecord(tableName, data, id);
        return result > 0 ? ResponseEntity.ok("Updated") : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
    }

    // Cập nhật bản ghi
    @PutMapping("/edit/{tableName}")
    public ResponseEntity<String> updateRecord(@PathVariable String tableName, @RequestBody Map<String, Object> recordData) throws Exception {
        int result = categoryService.updateRecord(tableName, recordData);
        return result > 0 ? ResponseEntity.ok("Updated") : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
    }

    // Xóa record
    @DeleteMapping("/delete/{tableName}/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable String tableName, @PathVariable Long id) {
        int result = categoryService.deleteRecord(tableName, id);
        return result > 0 ? ResponseEntity.ok("Deleted") : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
    }

    // Xóa bản ghi
    @DeleteMapping("/remove/{tableName}")
    public ResponseEntity<String> deleteRecord(
            @PathVariable String tableName,
            @RequestBody Map<String, Object> primaryKeyValues) throws Exception {
        int result = categoryService.deleteRecord(tableName, primaryKeyValues);
        return result > 0 ? ResponseEntity.ok("Deleted") : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
    }
}
