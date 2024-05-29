package com.juniors.sporteaseplatform.profiles.domain.model.queries;

public record GetAllProfileByTypeQuery(String type) {
    public GetAllProfileByTypeQuery {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        }
    }
}
