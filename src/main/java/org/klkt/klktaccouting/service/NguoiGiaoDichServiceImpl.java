package org.klkt.klktaccouting.service;

import org.klkt.klktaccouting.model.NguoiGiaoDich;
import org.klkt.klktaccouting.model.NguoiGiaoDichId;
import org.klkt.klktaccouting.repository.NguoiGiaoDichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NguoiGiaoDichServiceImpl implements NguoiGiaoDichService {
    
    @Autowired
    private NguoiGiaoDichRepository nguoiGiaoDichRepository;

    @Override
    public List<NguoiGiaoDich> getAllNguoiGiaoDich() {
        return nguoiGiaoDichRepository.findAll();
    }

    @Override
    public Optional<NguoiGiaoDich> getNguoiGiaoDichById(NguoiGiaoDichId id) {
        return nguoiGiaoDichRepository.findById(id);
    }

    @Override
    public NguoiGiaoDich saveNguoiGiaoDich(NguoiGiaoDich nguoiGiaoDich) {
        return nguoiGiaoDichRepository.save(nguoiGiaoDich);
    }

    @Override
    public void deleteNguoiGiaoDich(NguoiGiaoDichId id) {
        nguoiGiaoDichRepository.deleteById(id);
    }

    @Override
    public List<NguoiGiaoDich> getNguoiGiaoDichByMst(String mst) {
        return nguoiGiaoDichRepository.findByMst(mst);
    }
}