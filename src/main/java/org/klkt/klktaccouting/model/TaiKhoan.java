package org.klkt.klktaccouting.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbldmtaikhoan", schema = "public")
@IdClass(TaiKhoanId.class) // Chỉ định IdClass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaiKhoan {
    @Id
    @Column(name = "MST", length = 15, nullable = false)
    private String mst;

    @Id
    @Column(name = "SohieuTK", length = 10, nullable = false)
    private String soHieuTK;

    @Column(name = "Ten_TK", length = 70, nullable = false)
    private String tenTK;

    @Column(name = "Ten_TK_TA", length = 70, nullable = false)
    private String tenTKTiengAnh;

    @Column(name = "Du_No")
    private Boolean duNo;

    @Column(name = "Du_Co")
    private Boolean duCo;

    @Column(name = "Chitiet_Doituong")
    private Boolean chiTietDoiTuong;

    @Column(name = "TK_Vattu_hanghoa")
    private Boolean tkVatTuHangHoa;

    @Column(name = "Cap_chitet")
    private Integer capChiTiet;

    @Column(name = "Phieu_thu")
    private Boolean phieuThu;

    @Column(name = "Phieu_Chi")
    private Boolean phieuChi;

    @Column(name = "Phieu_Nhap")
    private Boolean phieuNhap;

    @Column(name = "Phieu_Xuat")
    private Boolean phieuXuat;

    @Column(name = "Ban_Hang")
    private Boolean banHang;

    @Column(name = "Ngan_Hang")
    private Boolean nganHang;

    @Column(name = "Tien_Luong")
    private Boolean tienLuong;

    @Column(name = "Khau_hao")
    private Boolean khauHao;

    @Column(name = "Gia_Thanh")
    private Boolean giaThanh;

    @Column(name = "Luu_Chuyen_NB")
    private Boolean luuChuyenNB;

    @Column(name = "Tinh_Gia_Von")
    private Boolean tinhGiaVon;

    @Column(name = "Chung_Tu_Khac")
    private Boolean chungTuKhac;

    @Column(name = "Ngoai_Bang")
    private Boolean ngoaiBang;

    @Column(name = "Su_Dung", nullable = false)
    private Boolean suDung = true;

    @Column(name = "Tu_ngay")
    private LocalDateTime tuNgay;

    @Column(name = "Den_Ngay")
    private LocalDateTime denNgay;

    @Column(name = "Du_No_Dau_Ky")
    private BigDecimal duNoDauKy;

    @Column(name = "Du_Co_Dau_Ky")
    private BigDecimal duCoDauKy;
}
