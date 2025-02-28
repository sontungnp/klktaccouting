package org.klkt.klktaccouting.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tbldmkhachhang", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang {

    @Id
    @Column(name = "ID", length = 20, nullable = false)
    private String id;

    @Column(name = "MST", length = 15, nullable = false)
    private String mst;

    @Column(name = "MST_KH_NCC", length = 15)
    private String mstKhNcc;

    @Column(name = "Ten_Congty", length = 150)
    private String tenCongty;

    @Column(name = "Du_No")
    private BigDecimal duNo;

    @Column(name = "Du_Co")
    private BigDecimal duCo;

    @Column(name = "Dia_Chi", length = 150)
    private String diaChi;

    @Column(name = "Huyen", length = 50)
    private String huyen;

    @Column(name = "Tinh", length = 50)
    private String tinh;

    @Column(name = "Dien_Thoai", length = 30)
    private String dienThoai;

    @Column(name = "Ten_Giamdoc", length = 30)
    private String tenGiamdoc;

    @Column(name = "Ten_Ketoan", length = 30)
    private String tenKetoan;

    @Column(name = "Linh_Vuc_KD", length = 100)
    private String linhVucKd;

    @Column(name = "Khach_Hang")
    private Boolean khachHang;

    @Column(name = "Nha_Cungcap")
    private Boolean nhaCungcap;

    @Column(name = "Tai_Khoan", length = 30)
    private String taiKhoan;

    @Column(name = "Ngan_Hang", length = 100)
    private String nganHang;

    @Column(name = "Cap")
    private Integer cap;
}
