package com.juniors.sporteaseplatform.transactions.interfaces.rest.resources;

import java.util.Date;

public record TransactionResource(Long id, Date publication, Date expiration) {
}
