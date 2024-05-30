package com.juniors.sporteaseplatform.categories.interfaces.rest.transform;

import com.juniors.sporteaseplatform.categories.domain.model.aggregates.Category;
import com.juniors.sporteaseplatform.categories.interfaces.rest.resources.CategoryResource;

public class CategoryResourceFromEntityAssembler {
    public static CategoryResource toResourceFromEntity(Category entity) {
        return new CategoryResource(entity.getId(), entity.getNameProfessor(), entity.getYearCategory());
    }
}
