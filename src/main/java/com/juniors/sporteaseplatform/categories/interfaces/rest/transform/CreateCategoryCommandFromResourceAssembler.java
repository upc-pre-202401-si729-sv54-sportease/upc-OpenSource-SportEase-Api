package com.juniors.sporteaseplatform.categories.interfaces.rest.transform;

import com.juniors.sporteaseplatform.categories.domain.model.commands.CreateCategoryCommand;
import com.juniors.sporteaseplatform.categories.interfaces.rest.resources.CreateCategoryResource;

public class CreateCategoryCommandFromResourceAssembler {
    public static CreateCategoryCommand toCommandFromResource(CreateCategoryResource resource) {
        return new CreateCategoryCommand(resource.nameProfessor(), resource.yearCategory());
    }
}
