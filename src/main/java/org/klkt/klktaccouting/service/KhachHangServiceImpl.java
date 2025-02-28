package org.klkt.klktaccouting.service;

import org.klkt.klktaccouting.model.KhachHang;
import org.klkt.klktaccouting.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> getAllKhachHang() {
        return khachHangRepository.findAll();
    }

    @Override
    public Optional<KhachHang> getKhachHangById(String id) {
        return khachHangRepository.findById(id);
    }

    @Override
    public KhachHang saveKhachHang(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    @Override
    public void deleteKhachHang(String id) {
        khachHangRepository.deleteById(id);
    }
}
