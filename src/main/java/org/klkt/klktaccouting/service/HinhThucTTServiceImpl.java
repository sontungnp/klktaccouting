package org.klkt.klktaccouting.service;

import org.klkt.klktaccouting.model.HinhThucTT;
import org.klkt.klktaccouting.repository.HinhThucTTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HinhThucTTServiceImpl implements HinhThucTTService {

    @Autowired
    private HinhThucTTRepository hinhThucTTRepository;

    @Override
    public List<HinhThucTT> getAllHinhThucTT() {
        return hinhThucTTRepository.findAll();
    }

    @Override
    public Optional<HinhThucTT> getHinhThucTTById(String maHTTT) {
        return hinhThucTTRepository.findById(maHTTT);
    }

    @Override
    public HinhThucTT saveHinhThucTT(HinhThucTT hinhThucTT) {
        return hinhThucTTRepository.save(hinhThucTT);
    }

    @Override
    public void deleteHinhThucTT(String maHTTT) {
        hinhThucTTRepository.deleteById(maHTTT);
    }
}
