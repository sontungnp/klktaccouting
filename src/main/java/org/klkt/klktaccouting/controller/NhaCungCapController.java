package org.klkt.klktaccouting.controller;

import org.klkt.klktaccouting.model.NhaCungCap;
import org.klkt.klktaccouting.service.NhaCungCapService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nhacungcap")
public class NhaCungCapController {
    private final NhaCungCapService service;

    public NhaCungCapController(NhaCungCapService service) {
        this.service = service;
    }

    @GetMapping
    public List<NhaCungCap> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhaCungCap> getById(@PathVariable String id) {
        Optional<NhaCungCap> nhaCungCap = service.getById(id);
        return nhaCungCap.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public NhaCungCap create(@RequestBody NhaCungCap nhaCungCap) {
        return service.save(nhaCungCap);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NhaCungCap> update(@PathVariable String id, @RequestBody NhaCungCap updated) {
        return service.getById(id)
                .map(existing -> {
                    updated.setId(id);
                    return ResponseEntity.ok(service.save(updated));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
