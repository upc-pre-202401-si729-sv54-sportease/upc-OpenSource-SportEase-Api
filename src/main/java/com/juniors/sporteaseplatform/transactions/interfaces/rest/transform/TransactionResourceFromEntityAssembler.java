package com.juniors.sporteaseplatform.transactions.interfaces.rest.transform;

import com.juniors.sporteaseplatform.transactions.domain.model.aggregates.Transaction;
import com.juniors.sporteaseplatform.transactions.interfaces.rest.resources.TransactionResource;

public class TransactionResourceFromEntityAssembler {
    public static TransactionResource toResourceFromEntity(Transaction entity) {
        return new TransactionResource(entity.getId(), entity.getPublication(), entity.getExpiration());
    }
}
