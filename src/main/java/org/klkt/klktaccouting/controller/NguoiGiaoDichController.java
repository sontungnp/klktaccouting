package org.klkt.klktaccouting.controller;

import org.klkt.klktaccouting.model.NguoiGiaoDich;
import org.klkt.klktaccouting.model.NguoiGiaoDichId;
import org.klkt.klktaccouting.service.NguoiGiaoDichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nguoi-giao-dich")
public class NguoiGiaoDichController {
    
    @Autowired
    private NguoiGiaoDichService nguoiGiaoDichService;

    @GetMapping
    public List<NguoiGiaoDich> getAllNguoiGiaoDich() {
        return nguoiGiaoDichService.getAllNguoiGiaoDich();
    }

    @GetMapping("/{mst}/{mstKh}/{maNguoiGd}")
    public Optional<NguoiGiaoDich> getNguoiGiaoDichById(@PathVariable String mst, @PathVariable String mstKh, @PathVariable String maNguoiGd) {
        return nguoiGiaoDichService.getNguoiGiaoDichById(new NguoiGiaoDichId(mst, mstKh, maNguoiGd));
    }

    @PostMapping
    public NguoiGiaoDich createNguoiGiaoDich(@RequestBody NguoiGiaoDich nguoiGiaoDich) {
        return nguoiGiaoDichService.saveNguoiGiaoDich(nguoiGiaoDich);
    }

    @PutMapping("/{mst}/{mstKh}/{maNguoiGd}")
    public NguoiGiaoDich updateNguoiGiaoDich(@PathVariable String mst, @PathVariable String mstKh, @PathVariable String maNguoiGd, @RequestBody NguoiGiaoDich nguoiGiaoDich) {
        return nguoiGiaoDichService.saveNguoiGiaoDich(nguoiGiaoDich);
    }

    @DeleteMapping("/{mst}/{mstKh}/{maNguoiGd}")
    public void deleteNguoiGiaoDich(@PathVariable String mst, @PathVariable String mstKh, @PathVariable String maNguoiGd) {
        nguoiGiaoDichService.deleteNguoiGiaoDich(new NguoiGiaoDichId(mst, mstKh, maNguoiGd));
    }

    @GetMapping("/mst/{mst}")
    public List<NguoiGiaoDich> getNguoiGiaoDichByMst(@PathVariable String mst) {
        return nguoiGiaoDichService.getNguoiGiaoDichByMst(mst);
    }
}