package com.juniors.sporteaseplatform.managements.infraestructure.persistance.jpa;

import com.juniors.sporteaseplatform.managements.domain.model.aggregates.Management;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ManagementRepository extends JpaRepository<Management, Long> {
    List<Management> findAllByType(String type);
    Optional<Management> findById(Long id);
}