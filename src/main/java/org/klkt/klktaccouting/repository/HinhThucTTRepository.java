package org.klkt.klktaccouting.repository;

import org.klkt.klktaccouting.model.HinhThucTT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HinhThucTTRepository extends JpaRepository<HinhThucTT, String> {
}
