package org.klkt.klktaccouting.service;

import org.klkt.klktaccouting.model.KhachHang;

import java.util.List;
import java.util.Optional;

public interface KhachHangService {
    List<KhachHang> getAllKhachHang();
    Optional<KhachHang> getKhachHangById(String id);
    KhachHang saveKhachHang(KhachHang khachHang);
    void deleteKhachHang(String id);
}
