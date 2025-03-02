package org.klkt.klktaccouting.repository;


import org.klkt.klktaccouting.model.VatTuHangHoa;
import org.klkt.klktaccouting.model.VatTuHangHoaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VatTuHangHoaRepository extends JpaRepository<VatTuHangHoa, VatTuHangHoaId> {
}
