package org.klkt.klktaccouting.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "k_metadata")
public class KMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tableName;
    private String columns; // JSON chứa các cột
    private String columnTypes; // JSON chứa kiểu dữ liệu
    private String columnValidations; // JSON chứa các quy tắc validate
    private String columnDropdownSources; // JSON chứa nguồn dropdown (tên bảng khác)
    private String tableDesc; // Mô tả table
    private String columnSearchs;
    private String columnPrimarys;
    // Getters and Setters
}
