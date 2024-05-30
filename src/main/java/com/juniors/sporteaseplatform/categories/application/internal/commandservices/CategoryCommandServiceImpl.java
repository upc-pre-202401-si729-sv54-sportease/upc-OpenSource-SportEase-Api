package com.juniors.sporteaseplatform.categories.application.internal.commandservices;

import com.juniors.sporteaseplatform.categories.domain.model.aggregates.Category;
import com.juniors.sporteaseplatform.categories.domain.model.commands.CreateCategoryCommand;
import com.juniors.sporteaseplatform.categories.domain.services.CategoryCommandService;
import com.juniors.sporteaseplatform.categories.infraestructure.persistance.jpa.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryCommandServiceImpl implements CategoryCommandService {
    private final CategoryRepository categoryRepository;

    public CategoryCommandServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> handle(CreateCategoryCommand command) {
        var category = new Category(command);
        var createdCategory = categoryRepository.save(category);
        return Optional.of(createdCategory);
    }
}
