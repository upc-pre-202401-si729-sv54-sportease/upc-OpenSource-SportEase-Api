package com.juniors.sporteaseplatform.transactions.interfaces.rest.resources;

import java.util.Date;

public record CreateTransactionResource(Date expiration) {
    public CreateTransactionResource{
        if(expiration ==null){
            throw new IllegalArgumentException("expiration cannot be null");
        }
    }
}
