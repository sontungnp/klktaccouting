package org.klkt.klktaccouting.repository;


import org.klkt.klktaccouting.model.KhoHang;
import org.klkt.klktaccouting.model.KhoHangId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoHangRepository extends JpaRepository<KhoHang, KhoHangId> {
}
