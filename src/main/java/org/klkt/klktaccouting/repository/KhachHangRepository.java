package org.klkt.klktaccouting.repository;

import org.klkt.klktaccouting.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, String> {
}
