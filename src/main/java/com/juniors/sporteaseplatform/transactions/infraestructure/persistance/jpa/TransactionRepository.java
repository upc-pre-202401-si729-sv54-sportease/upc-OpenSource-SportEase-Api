package com.juniors.sporteaseplatform.transactions.infraestructure.persistance.jpa;

import com.juniors.sporteaseplatform.transactions.domain.model.aggregates.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<Transaction> findById(Long id);
}