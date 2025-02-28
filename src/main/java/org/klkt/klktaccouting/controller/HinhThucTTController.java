package org.klkt.klktaccouting.controller;

import org.klkt.klktaccouting.model.HinhThucTT;
import org.klkt.klktaccouting.service.HinhThucTTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hinhthuctt")
public class HinhThucTTController {

    @Autowired
    private HinhThucTTService hinhThucTTService;

    // Lấy danh sách hình thức thanh toán
    @GetMapping
    public List<HinhThucTT> getAllHinhThucTT() {
        return hinhThucTTService.getAllHinhThucTT();
    }

    // Lấy hình thức thanh toán theo mã
    @GetMapping("/{maHTTT}")
    public Optional<HinhThucTT> getHinhThucTTById(@PathVariable String maHTTT) {
        return hinhThucTTService.getHinhThucTTById(maHTTT);
    }

    // Thêm mới hình thức thanh toán
    @PostMapping
    public HinhThucTT createHinhThucTT(@RequestBody HinhThucTT hinhThucTT) {
        return hinhThucTTService.saveHinhThucTT(hinhThucTT);
    }

    // Cập nhật hình thức thanh toán
    @PutMapping("/{maHTTT}")
    public HinhThucTT updateHinhThucTT(@PathVariable String maHTTT, @RequestBody HinhThucTT hinhThucTT) {
        return hinhThucTTService.saveHinhThucTT(hinhThucTT);
    }

    // Xóa hình thức thanh toán theo mã
    @DeleteMapping("/{maHTTT}")
    public void deleteHinhThucTT(@PathVariable String maHTTT) {
        hinhThucTTService.deleteHinhThucTT(maHTTT);
    }
}
