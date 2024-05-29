package com.juniors.sporteaseplatform.profiles.domain.services;

import com.juniors.sporteaseplatform.profiles.domain.model.aggregates.Profile;
import com.juniors.sporteaseplatform.profiles.domain.model.queries.GetAllProfileByTypeQuery;

import java.util.List;

public interface ProfileQueryService {
    List<Profile> handle(GetAllProfileByTypeQuery query);
}
