package org.klkt.klktaccouting.service;

import org.klkt.klktaccouting.model.VatTuHangHoa;
import org.klkt.klktaccouting.model.VatTuHangHoaId;
import org.klkt.klktaccouting.repository.VatTuHangHoaRepository;
import org.klkt.klktaccouting.service.VatTuHangHoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VatTuHangHoaServiceImpl implements VatTuHangHoaService {

    @Autowired
    private VatTuHangHoaRepository repository;

    @Override
    public List<VatTuHangHoa> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<VatTuHangHoa> getById(String mst, String sohieuTK, String maKho, String maNhom, String maVattu) {
        VatTuHangHoaId id = new VatTuHangHoaId(mst, sohieuTK, maKho, maNhom, maVattu);
        return repository.findById(id);
    }

    @Override
    public VatTuHangHoa save(VatTuHangHoa vatTuHangHoa) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void deleteById(String mst, String sohieuTK, String maKho, String maNhom, String maVattu) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
}
