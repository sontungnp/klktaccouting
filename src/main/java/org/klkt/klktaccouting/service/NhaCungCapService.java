package org.klkt.klktaccouting.service;

import org.klkt.klktaccouting.model.NhaCungCap;
import org.klkt.klktaccouting.model.NhaCungCapId;
import org.klkt.klktaccouting.repository.NhaCungCapRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhaCungCapService {
    private final NhaCungCapRepository repository;

    public NhaCungCapService(NhaCungCapRepository repository) {
        this.repository = repository;
    }

    public List<NhaCungCap> getAll() {
        return repository.findAll();
    }

    public Optional<NhaCungCap> getById(String id) {
        return repository.findById(id);
    }

    public NhaCungCap save(NhaCungCap nhaCungCap) {
        return repository.save(nhaCungCap);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}

