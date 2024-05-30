package com.juniors.sporteaseplatform.managements.interfaces.rest.transform;

import com.juniors.sporteaseplatform.managements.domain.model.commands.CreateManagementCommand;
import com.juniors.sporteaseplatform.managements.interfaces.rest.resources.CreateManagementResource;

public class CreateManagementCommandFromResourceAssembler {
    public static CreateManagementCommand toCommandFromResource(CreateManagementResource resource) {
        return new CreateManagementCommand(resource.name(), resource.lastName(), resource.email(), resource.password(),
                resource.type(), resource.nameClub());
    }
}
