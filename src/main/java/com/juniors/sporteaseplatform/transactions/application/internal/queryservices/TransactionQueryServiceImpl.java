package com.juniors.sporteaseplatform.transactions.application.internal.queryservices;

import com.juniors.sporteaseplatform.transactions.domain.model.aggregates.Transaction;
import com.juniors.sporteaseplatform.transactions.domain.model.queries.GetTransactionByIdQuery;
import com.juniors.sporteaseplatform.transactions.domain.model.queries.GetAllTransactionQuery;
import com.juniors.sporteaseplatform.transactions.domain.services.TransactionQueryService;
import com.juniors.sporteaseplatform.transactions.infraestructure.persistance.jpa.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionQueryServiceImpl implements TransactionQueryService {

    private final TransactionRepository transactionRepository;

    public TransactionQueryServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Optional<Transaction> handle(GetTransactionByIdQuery query) {
        return transactionRepository.findById(query.id());
    }

    @Override
    public List<Transaction> handle(GetAllTransactionQuery query) {
        return transactionRepository.findAll();
    }
}
