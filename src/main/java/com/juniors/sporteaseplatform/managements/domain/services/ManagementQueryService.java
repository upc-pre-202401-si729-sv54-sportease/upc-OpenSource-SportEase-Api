package com.juniors.sporteaseplatform.managements.domain.services;

import com.juniors.sporteaseplatform.managements.domain.model.aggregates.Management;
import com.juniors.sporteaseplatform.managements.domain.model.queries.GetAllManagementByTypeQuery;
import com.juniors.sporteaseplatform.managements.domain.model.queries.GetAllManagementQuery;

import java.util.List;
import java.util.Optional;

public interface ManagementQueryService {
    List<Management> handle(GetAllManagementByTypeQuery query);
    List<Management> handle(GetAllManagementQuery query);
}
