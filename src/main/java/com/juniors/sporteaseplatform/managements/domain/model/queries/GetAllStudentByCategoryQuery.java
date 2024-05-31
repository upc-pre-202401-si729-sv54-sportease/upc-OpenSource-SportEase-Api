package com.juniors.sporteaseplatform.managements.domain.model.queries;

public record GetAllStudentByCategoryQuery(Integer category) {
    public GetAllStudentByCategoryQuery {
        if (category == null) {
            throw new IllegalArgumentException("category cannot be null");
        }
    }
}
