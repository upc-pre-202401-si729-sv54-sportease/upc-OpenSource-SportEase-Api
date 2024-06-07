package com.juniors.sporteaseplatform.managements.domain.model.queries;

public record PutManagementQuery(Long id) {
    public PutManagementQuery {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
    }
}
