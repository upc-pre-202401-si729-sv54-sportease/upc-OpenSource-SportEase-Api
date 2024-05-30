package com.juniors.sporteaseplatform.categories.domain.services;

import com.juniors.sporteaseplatform.categories.domain.model.aggregates.Category;
import com.juniors.sporteaseplatform.categories.domain.model.queries.GetCategoryByIdQuery;
import com.juniors.sporteaseplatform.categories.domain.model.queries.GetAllCategoryByYearCategoryQuery;
import com.juniors.sporteaseplatform.categories.domain.model.queries.GetAllCategoryQuery;

import java.util.List;
import java.util.Optional;

public interface CategoryQueryService {
    Optional<Category> handle(GetCategoryByIdQuery query);
    List<Category> handle(GetAllCategoryQuery query);
    List<Category> handle(GetAllCategoryByYearCategoryQuery query);
}
