package com.juniors.sporteaseplatform.categories.application.internal.queryservices;

import com.juniors.sporteaseplatform.categories.domain.model.aggregates.Category;
import com.juniors.sporteaseplatform.categories.domain.model.queries.GetCategoryByIdQuery;
import com.juniors.sporteaseplatform.categories.domain.model.queries.GetAllCategoryByYearCategoryQuery;
import com.juniors.sporteaseplatform.categories.domain.model.queries.GetAllCategoryQuery;
import com.juniors.sporteaseplatform.categories.domain.services.CategoryQueryService;
import com.juniors.sporteaseplatform.categories.infraestructure.persistance.jpa.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryQueryServiceImpl implements CategoryQueryService {

    private final CategoryRepository categoryRepository;

    public CategoryQueryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> handle(GetCategoryByIdQuery query) {
        return categoryRepository.findById(query.id());
    }

    @Override
    public List<Category> handle(GetAllCategoryQuery query) {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> handle(GetAllCategoryByYearCategoryQuery query) {
        return categoryRepository.findAllByYearCategory(query.yearCategory());
    }
}
