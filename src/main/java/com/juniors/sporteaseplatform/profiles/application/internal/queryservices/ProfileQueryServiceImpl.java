package com.juniors.sporteaseplatform.profiles.application.internal.queryservices;

import com.juniors.sporteaseplatform.profiles.domain.model.aggregates.Profile;
import com.juniors.sporteaseplatform.profiles.domain.model.queries.GetAllProfileByTypeQuery;
import com.juniors.sporteaseplatform.profiles.domain.services.ProfileQueryService;
import com.juniors.sporteaseplatform.profiles.infraestructure.persistance.jpa.ProfileRepository;

import java.util.List;

public class ProfileQueryServiceImpl implements ProfileQueryService {

    private final ProfileRepository profileRepository;

    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> handle(GetAllProfileByTypeQuery query) {
        return profileRepository.findAllByType(query.type());
    }
}
