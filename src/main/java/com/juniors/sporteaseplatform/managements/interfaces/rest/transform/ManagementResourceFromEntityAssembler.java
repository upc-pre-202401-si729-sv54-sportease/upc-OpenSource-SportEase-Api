package com.juniors.sporteaseplatform.managements.interfaces.rest.transform;

import com.juniors.sporteaseplatform.managements.domain.model.aggregates.Management;
import com.juniors.sporteaseplatform.managements.interfaces.rest.resources.ManagementResource;

public class ManagementResourceFromEntityAssembler {
    public static ManagementResource toResourceFromEntity(Management entity) {
        return new ManagementResource(entity.getId(), entity.getName(), entity.getLastName(),
                entity.getEmail(), entity.getPassword(), entity.getType(), entity.getNameClub());
    }
}
