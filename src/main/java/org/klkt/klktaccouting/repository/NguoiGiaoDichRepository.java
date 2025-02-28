package org.klkt.klktaccouting.repository;

import org.klkt.klktaccouting.model.NguoiGiaoDich;
import org.klkt.klktaccouting.model.NguoiGiaoDichId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NguoiGiaoDichRepository extends JpaRepository<NguoiGiaoDich, NguoiGiaoDichId> {
    List<NguoiGiaoDich> findByMst(String mst);
}