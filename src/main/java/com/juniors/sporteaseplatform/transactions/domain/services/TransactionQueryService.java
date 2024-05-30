package com.juniors.sporteaseplatform.transactions.domain.services;

import com.juniors.sporteaseplatform.transactions.domain.model.aggregates.Transaction;
import com.juniors.sporteaseplatform.transactions.domain.model.queries.GetTransactionByIdQuery;
import com.juniors.sporteaseplatform.transactions.domain.model.queries.GetAllTransactionQuery;

import java.util.List;
import java.util.Optional;

public interface TransactionQueryService {
    Optional<Transaction> handle(GetTransactionByIdQuery query);
    List<Transaction> handle(GetAllTransactionQuery query);
}
