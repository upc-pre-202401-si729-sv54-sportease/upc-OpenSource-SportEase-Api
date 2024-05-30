package com.juniors.sporteaseplatform.managements.domain.model.queries;

public record GetAllManagementByTypeQuery(String type) {
    public GetAllManagementByTypeQuery {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        }
    }
}
