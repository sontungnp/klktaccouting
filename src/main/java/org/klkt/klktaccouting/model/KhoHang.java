package org.klkt.klktaccouting.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbldmkhohang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhoHang {

    @EmbeddedId
    private KhoHangId id;

    @Column(name = "Ma_Kho", length = 10, nullable = false)
    private String maKho;

    @Column(name = "Ten_Kho", length = 100)
    private String tenKho;
}