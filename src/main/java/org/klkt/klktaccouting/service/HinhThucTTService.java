package org.klkt.klktaccouting.service;

import org.klkt.klktaccouting.model.HinhThucTT;

import java.util.List;
import java.util.Optional;

public interface HinhThucTTService {
    List<HinhThucTT> getAllHinhThucTT();
    Optional<HinhThucTT> getHinhThucTTById(String maHTTT);
    HinhThucTT saveHinhThucTT(HinhThucTT hinhThucTT);
    void deleteHinhThucTT(String maHTTT);
}
