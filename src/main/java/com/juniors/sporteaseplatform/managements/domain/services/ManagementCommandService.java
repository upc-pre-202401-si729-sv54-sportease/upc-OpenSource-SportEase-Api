package com.juniors.sporteaseplatform.managements.domain.services;

import com.juniors.sporteaseplatform.managements.domain.model.aggregates.Management;
import com.juniors.sporteaseplatform.managements.domain.model.commands.CreateManagementCommand;
import com.juniors.sporteaseplatform.managements.domain.model.commands.UpdateManagementCommand;

import java.util.Optional;

public interface ManagementCommandService {
    Optional<Management> handle(CreateManagementCommand command);
    Optional<Management> handle(UpdateManagementCommand command);
}
