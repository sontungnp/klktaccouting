package org.klkt.klktaccouting.controller;

import org.klkt.klktaccouting.model.VatTuHangHoa;
import org.klkt.klktaccouting.service.VatTuHangHoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vat-tu-hang-hoa")
public class VatTuHangHoaController {

    @Autowired
    private VatTuHangHoaService service;

    @GetMapping
    public List<VatTuHangHoa> getAll() {
        return service.getAll();
    }

    @GetMapping("/{mst}/{sohieuTK}/{maKho}/{maNhom}/{maVattu}")
    public ResponseEntity<VatTuHangHoa> getById(@PathVariable String mst, 
                                                @PathVariable String sohieuTK,
                                                @PathVariable String maKho,
                                                @PathVariable String maNhom,
                                                @PathVariable String maVattu) {
        Optional<VatTuHangHoa> vatTuHangHoa = service.getById(mst, sohieuTK, maKho, maNhom, maVattu);
        return vatTuHangHoa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public VatTuHangHoa create(@RequestBody VatTuHangHoa vatTuHangHoa) {
        return service.save(vatTuHangHoa);
    }

    @PutMapping
    public VatTuHangHoa update(@RequestBody VatTuHangHoa vatTuHangHoa) {
        return service.save(vatTuHangHoa);
    }

    @DeleteMapping("/{mst}/{sohieuTK}/{maKho}/{maNhom}/{maVattu}")
    public ResponseEntity<Void> delete(@PathVariable String mst, 
                                       @PathVariable String sohieuTK,
                                       @PathVariable String maKho,
                                       @PathVariable String maNhom,
                                       @PathVariable String maVattu) {
        service.deleteById(mst, sohieuTK, maKho, maNhom, maVattu);
        return ResponseEntity.noContent().build();
    }
}
