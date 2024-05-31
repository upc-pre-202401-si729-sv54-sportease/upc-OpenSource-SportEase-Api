package com.juniors.sporteaseplatform.managements.interfaces.rest.transform;

import com.juniors.sporteaseplatform.managements.domain.model.commands.CreateStudentCommand;
import com.juniors.sporteaseplatform.managements.interfaces.rest.resources.CreateStudentResource;

public class CreateStudentCommandFromResourceAssembler {
    public static CreateStudentCommand toCommandFromResource(CreateStudentResource resource) {
        return new CreateStudentCommand(resource.name(), resource.lastName(), resource.email(), resource.password(),
                resource.type(), resource.category());
    }
}
