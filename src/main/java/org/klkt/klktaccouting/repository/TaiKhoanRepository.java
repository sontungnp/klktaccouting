package org.klkt.klktaccouting.repository;

import org.klkt.klktaccouting.model.TaiKhoan;
import org.klkt.klktaccouting.model.TaiKhoanId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, TaiKhoanId> {
}
