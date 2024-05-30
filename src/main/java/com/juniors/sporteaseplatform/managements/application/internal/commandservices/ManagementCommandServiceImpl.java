package com.juniors.sporteaseplatform.managements.application.internal.commandservices;

import com.juniors.sporteaseplatform.managements.domain.model.aggregates.Management;
import com.juniors.sporteaseplatform.managements.domain.model.commands.CreateManagementCommand;
import com.juniors.sporteaseplatform.managements.domain.services.ManagementCommandService;
import com.juniors.sporteaseplatform.managements.infraestructure.persistance.jpa.ManagementRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagementCommandServiceImpl implements ManagementCommandService {
    private final ManagementRepository managementRepository;

    public ManagementCommandServiceImpl(ManagementRepository managementRepository) {
        this.managementRepository = managementRepository;
    }

    @Override
    public Optional<Management> handle(CreateManagementCommand command) {
        var management = new Management(command);
        var createdManagement = managementRepository.save(management);
        return Optional.of(createdManagement);
    }
}
