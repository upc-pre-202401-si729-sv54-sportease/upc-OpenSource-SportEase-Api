package com.juniors.sporteaseplatform.transactions.domain.model.queries;

public record GetTransactionByIdQuery(Long id) {
    public GetTransactionByIdQuery {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
    }
}
