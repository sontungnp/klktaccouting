package org.klkt.klktaccouting.service;

import org.klkt.klktaccouting.model.VatTuHangHoa;

import java.util.List;
import java.util.Optional;

public interface VatTuHangHoaService {
    List<VatTuHangHoa> getAll();
    Optional<VatTuHangHoa> getById(String mst, String sohieuTK, String maKho, String maNhom, String maVattu);
    VatTuHangHoa save(VatTuHangHoa vatTuHangHoa);
    void deleteById(String mst, String sohieuTK, String maKho, String maNhom, String maVattu);
}
