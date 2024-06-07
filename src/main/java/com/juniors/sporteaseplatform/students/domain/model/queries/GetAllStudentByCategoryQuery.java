package com.juniors.sporteaseplatform.students.domain.model.queries;

public record GetAllStudentByCategoryQuery(Integer category) {
    public GetAllStudentByCategoryQuery {
        if (category == null) {
            throw new IllegalArgumentException("category cannot be null");
        }
    }
}
