package com.juniors.sporteaseplatform.transactions.interfaces.rest.transform;

import com.juniors.sporteaseplatform.transactions.domain.model.commands.CreateTransactionCommand;
import com.juniors.sporteaseplatform.transactions.interfaces.rest.resources.CreateTransactionResource;
import com.juniors.sporteaseplatform.transactions.interfaces.rest.resources.TransactionResource;

public class CreateTransactionCommandFromResourceAssembler {
    public static CreateTransactionCommand toCommandFromResource(CreateTransactionResource resource) {
        return new CreateTransactionCommand(resource.expiration());
    }
}
