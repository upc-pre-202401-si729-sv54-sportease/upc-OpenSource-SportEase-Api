package com.juniors.sporteaseplatform.students.interfaces.rest.transform;

import com.juniors.sporteaseplatform.students.domain.model.commands.CreateStudentCommand;
import com.juniors.sporteaseplatform.students.interfaces.rest.resources.CreateStudentResource;

public class CreateStudentCommandFromResourceAssembler {
    public static CreateStudentCommand toCommandFromResource(CreateStudentResource resource) {
        return new CreateStudentCommand(resource.name(), resource.lastName(), resource.email(), resource.password(),
                resource.type(), resource.category());
    }
}
