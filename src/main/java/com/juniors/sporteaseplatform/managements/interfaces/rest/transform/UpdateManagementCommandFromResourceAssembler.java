package com.juniors.sporteaseplatform.managements.interfaces.rest.transform;

import com.juniors.sporteaseplatform.managements.domain.model.commands.UpdateManagementCommand;
import com.juniors.sporteaseplatform.managements.interfaces.rest.resources.UpdateManagementResource;

public class UpdateManagementCommandFromResourceAssembler {
    public static UpdateManagementCommand toCommandFromResource(Long id, UpdateManagementResource resource) {
        return new UpdateManagementCommand(
                id,
                resource.getName(),
                resource.getLastName(),
                resource.getEmail(),
                resource.getPassword(),
                resource.getType(),
                resource.getNameClub()
        );
    }
}
