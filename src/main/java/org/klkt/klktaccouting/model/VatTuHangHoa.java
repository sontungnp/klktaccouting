package org.klkt.klktaccouting.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tbldmvattu_hanghoa", schema = "public")
@IdClass(VatTuHangHoaId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VatTuHangHoa {

    @Id
    @Column(name = "MST", length = 15)
    private String mst;

    @Id
    @Column(name = "SohieuTK", length = 10)
    private String sohieuTK;

    @Id
    @Column(name = "Ma_Kho", length = 10)
    private String maKho;

    @Id
    @Column(name = "Ma_Nhom", length = 20)
    private String maNhom;

    @Id
    @Column(name = "Ma_Vattu", length = 20)
    private String maVattu;

    @Column(name = "Ten_Vattu", length = 100)
    private String tenVattu;

    @Column(name = "DVT", length = 10)
    private String dvt;

    @Column(name = "Luong_Dau_Ky")
    private BigDecimal luongDauKy;

    @Column(name = "Gia_Tri_Dau_Ky")
    private BigDecimal giaTriDauKy;

    @Column(name = "He_So_Quy_Doi")
    private BigDecimal heSoQuyDoi;

    @Column(name = "Ma_Don_Vi_Quy_Doi", length = 10)
    private String maDonViQuyDoi;

    @Column(name = "Vi_Tri_Luu_tru", length = 50)
    private String viTriLuuTru;

    @Column(name = "Nam")
    private Integer nam;
}

