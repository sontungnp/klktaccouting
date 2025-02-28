package org.klkt.klktaccouting.service;

import org.klkt.klktaccouting.model.NguoiGiaoDich;
import org.klkt.klktaccouting.model.NguoiGiaoDichId;
import java.util.List;
import java.util.Optional;

public interface NguoiGiaoDichService {
    List<NguoiGiaoDich> getAllNguoiGiaoDich();
    Optional<NguoiGiaoDich> getNguoiGiaoDichById(NguoiGiaoDichId id);
    NguoiGiaoDich saveNguoiGiaoDich(NguoiGiaoDich nguoiGiaoDich);
    void deleteNguoiGiaoDich(NguoiGiaoDichId id);
    List<NguoiGiaoDich> getNguoiGiaoDichByMst(String mst);
}