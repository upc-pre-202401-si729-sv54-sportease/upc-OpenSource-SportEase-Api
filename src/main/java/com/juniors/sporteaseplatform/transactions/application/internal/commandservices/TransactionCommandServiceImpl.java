package com.juniors.sporteaseplatform.transactions.application.internal.commandservices;

import com.juniors.sporteaseplatform.transactions.domain.model.aggregates.Transaction;
import com.juniors.sporteaseplatform.transactions.domain.model.commands.CreateTransactionCommand;
import com.juniors.sporteaseplatform.transactions.domain.services.TransactionCommandService;
import com.juniors.sporteaseplatform.transactions.infraestructure.persistance.jpa.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionCommandServiceImpl implements TransactionCommandService {
    private final TransactionRepository transactionRepository;

    public TransactionCommandServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Optional<Transaction> handle(CreateTransactionCommand command) {
        var transaction = new Transaction(command);
        var createdTransaction = transactionRepository.save(transaction);
        return Optional.of(createdTransaction);
    }
}
