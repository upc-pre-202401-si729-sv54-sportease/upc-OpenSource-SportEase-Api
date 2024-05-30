package com.juniors.sporteaseplatform.categories.domain.model.queries;

public record GetCategoryByIdQuery(Long id) {
    public GetCategoryByIdQuery {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
    }
}
