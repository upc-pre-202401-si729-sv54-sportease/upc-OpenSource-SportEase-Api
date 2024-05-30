package com.juniors.sporteaseplatform.categories.domain.services;

import com.juniors.sporteaseplatform.categories.domain.model.aggregates.Category;
import com.juniors.sporteaseplatform.categories.domain.model.commands.CreateCategoryCommand;

import java.util.Optional;

public interface CategoryCommandService {
    Optional<Category> handle(CreateCategoryCommand command);
}
