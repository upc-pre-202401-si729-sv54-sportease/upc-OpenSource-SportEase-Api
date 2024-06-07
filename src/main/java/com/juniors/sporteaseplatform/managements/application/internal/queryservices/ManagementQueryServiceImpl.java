package com.juniors.sporteaseplatform.managements.application.internal.queryservices;

import com.juniors.sporteaseplatform.managements.domain.model.aggregates.Management;
import com.juniors.sporteaseplatform.managements.domain.model.queries.GetAllManagementByTypeQuery;
import com.juniors.sporteaseplatform.managements.domain.model.queries.GetAllManagementQuery;
import com.juniors.sporteaseplatform.managements.domain.model.queries.PutManagementQuery;
import com.juniors.sporteaseplatform.managements.domain.services.ManagementQueryService;
import com.juniors.sporteaseplatform.managements.infraestructure.persistance.jpa.ManagementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagementQueryServiceImpl implements ManagementQueryService {

    private final ManagementRepository managementRepository;

    public ManagementQueryServiceImpl(ManagementRepository managementRepository) {
        this.managementRepository = managementRepository;
    }

    @Override
    public List<Management> handle(GetAllManagementByTypeQuery query) {
        return managementRepository.findAllByType(query.type());
    }

    @Override
    public List<Management> handle(GetAllManagementQuery query) {
        return managementRepository.findAll();
    }

    @Override
    public Optional<Management> handle(PutManagementQuery query) {
        return managementRepository.findById(query.id());
    }
}
