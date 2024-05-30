package com.juniors.sporteaseplatform.transactions.domain.model.commands;

import java.util.Date;

public record CreateTransactionCommand(Date expiration) {
    public CreateTransactionCommand {
        if(expiration ==null){
            throw new IllegalArgumentException("expiration is null");
        }
    }
}
