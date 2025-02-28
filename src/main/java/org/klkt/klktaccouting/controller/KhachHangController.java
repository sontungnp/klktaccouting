package org.klkt.klktaccouting.controller;

import org.klkt.klktaccouting.model.KhachHang;
import org.klkt.klktaccouting.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/khachhang")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    // Lấy danh sách khách hàng
    @GetMapping
    public List<KhachHang> getAllKhachHang() {
        return khachHangService.getAllKhachHang();
    }

    // Lấy thông tin khách hàng theo ID
    @GetMapping("/{id}")
    public Optional<KhachHang> getKhachHangById(@PathVariable String id) {
        return khachHangService.getKhachHangById(id);
    }

    // Thêm mới khách hàng
    @PostMapping
    public KhachHang createKhachHang(@RequestBody KhachHang khachHang) {
        return khachHangService.saveKhachHang(khachHang);
    }

    // Cập nhật thông tin khách hàng
    @PutMapping("/{id}")
    public KhachHang updateKhachHang(@PathVariable String id, @RequestBody KhachHang khachHang) {
        return khachHangService.saveKhachHang(khachHang);
    }

    // Xóa khách hàng theo ID
    @DeleteMapping("/{id}")
    public void deleteKhachHang(@PathVariable String id) {
        khachHangService.deleteKhachHang(id);
    }
}
