package org.klkt.klktaccouting.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbldmnguoi_giaodich", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(NguoiGiaoDichId.class)
public class NguoiGiaoDich {
    @Id
    @Column(name = "MST", length = 15, nullable = false)
    private String mst;

    @Id
    @Column(name = "MST_KH", length = 15, nullable = false)
    private String mstKh;

    @Id
    @Column(name = "Ma_nguoi_GD", length = 20, nullable = false)
    private String maNguoiGd;

    @Column(name = "Ten_Nguoi_GD", length = 100)
    private String tenNguoiGd;
}