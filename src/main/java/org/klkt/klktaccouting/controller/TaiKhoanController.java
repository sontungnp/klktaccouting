package org.klkt.klktaccouting.controller;

import org.klkt.klktaccouting.model.TaiKhoan;
import org.klkt.klktaccouting.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/taikhoan")
public class TaiKhoanController {

    @Autowired
    private TaiKhoanService service;

    @GetMapping
    public List<TaiKhoan> getAllTaiKhoan() {
        return service.getAllTaiKhoan();
    }

    @GetMapping("/{mst}/{soHieuTK}")
    public ResponseEntity<TaiKhoan> getTaiKhoanById(@PathVariable String mst, @PathVariable String soHieuTK) {
        Optional<TaiKhoan> taiKhoan = service.getTaiKhoanById(mst, soHieuTK);
        return taiKhoan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TaiKhoan> createTaiKhoan(@RequestBody TaiKhoan taiKhoan) {
        TaiKhoan savedTaiKhoan = service.saveTaiKhoan(taiKhoan);
        return ResponseEntity.ok(savedTaiKhoan);
    }

    @DeleteMapping("/{mst}/{soHieuTK}")
    public ResponseEntity<Void> deleteTaiKhoan(@PathVariable String mst, @PathVariable String soHieuTK) {
        service.deleteTaiKhoan(mst, soHieuTK);
        return ResponseEntity.noContent().build();
    }
}
