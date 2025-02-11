package org.klkt.klktaccouting.repository;

import org.klkt.klktaccouting.model.KMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryMetadataRepository extends JpaRepository<KMetadata, Long> {
    Optional<KMetadata> findByTableName(String tableName);
}
