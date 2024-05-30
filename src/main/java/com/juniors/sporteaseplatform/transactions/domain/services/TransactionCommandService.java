package com.juniors.sporteaseplatform.transactions.domain.services;

import com.juniors.sporteaseplatform.transactions.domain.model.aggregates.Transaction;
import com.juniors.sporteaseplatform.transactions.domain.model.commands.CreateTransactionCommand;

import java.util.Optional;

public interface TransactionCommandService {
    Optional<Transaction> handle(CreateTransactionCommand command);
}
