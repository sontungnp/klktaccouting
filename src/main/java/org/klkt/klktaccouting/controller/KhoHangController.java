package org.klkt.klktaccouting.controller;

import org.klkt.klktaccouting.model.KhoHang;
import org.klkt.klktaccouting.service.KhoHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khohang")
public class KhoHangController {

    @Autowired
    private KhoHangService khoHangService;

    @GetMapping
    public List<KhoHang> getAllKhoHang() {
        return khoHangService.getAllKhoHang();
    }

    @PostMapping
    public KhoHang createKhoHang(@RequestBody KhoHang khoHang) {
        return khoHangService.createKhoHang(khoHang);
    }
}
