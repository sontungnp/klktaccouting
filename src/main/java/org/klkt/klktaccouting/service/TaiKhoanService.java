package org.klkt.klktaccouting.service;

import org.klkt.klktaccouting.model.TaiKhoan;
import org.klkt.klktaccouting.model.TaiKhoanId;
import org.klkt.klktaccouting.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaiKhoanService {
    @Autowired
    private TaiKhoanRepository repository;

    public List<TaiKhoan> getAllTaiKhoan() {
        return repository.findAll();
    }

    public Optional<TaiKhoan> getTaiKhoanById(String mst, String soHieuTK) {
        TaiKhoanId id = new TaiKhoanId(mst, soHieuTK);
        return repository.findById(id);
    }

    public TaiKhoan saveTaiKhoan(TaiKhoan taiKhoan) {
        return repository.save(taiKhoan);
    }

    public TaiKhoan updateTaiKhoan(TaiKhoan taiKhoan) {
        return repository.save(taiKhoan);
    }

    public void deleteTaiKhoan(String mst, String soHieuTK) {
        TaiKhoanId id = new TaiKhoanId(mst, soHieuTK);
        repository.deleteById(id);
    }
}
