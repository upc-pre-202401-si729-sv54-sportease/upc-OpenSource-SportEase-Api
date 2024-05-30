package com.juniors.sporteaseplatform.categories.domain.model.queries;

public record GetAllCategoryByYearCategoryQuery(Integer yearCategory) {
    public GetAllCategoryByYearCategoryQuery{
        if(yearCategory == null){
            throw new IllegalArgumentException("yearCategory cannot be null");
        }
    }
}
