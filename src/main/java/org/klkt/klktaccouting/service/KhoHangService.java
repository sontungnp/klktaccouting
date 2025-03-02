package org.klkt.klktaccouting.service;

import org.klkt.klktaccouting.model.KhoHang;
import org.klkt.klktaccouting.model.KhoHangId;
import org.klkt.klktaccouting.repository.KhoHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhoHangService {

    @Autowired
    private KhoHangRepository khoHangRepository;

    public List<KhoHang> getAllKhoHang() {
        return khoHangRepository.findAll();
    }

    public Optional<KhoHang> getKhoHangById(KhoHangId id) {
        return khoHangRepository.findById(id);
    }

    public KhoHang createKhoHang(KhoHang khoHang) {
        return khoHangRepository.save(khoHang);
    }

    public void deleteKhoHang(KhoHangId id) {
        khoHangRepository.deleteById(id);
    }
}
