package com.juniors.sporteaseplatform.profiles.application.internal.commandservices;

import com.juniors.sporteaseplatform.profiles.domain.model.aggregates.Profile;
import com.juniors.sporteaseplatform.profiles.domain.model.commands.CreateProfileCommand;
import com.juniors.sporteaseplatform.profiles.domain.services.ProfileCommandService;
import com.juniors.sporteaseplatform.profiles.infraestructure.persistance.jpa.ProfileRepository;

import java.util.Optional;

public class ProfileCommandServiceImpl implements ProfileCommandService {
    private final ProfileRepository profileRepository;

    public ProfileCommandServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Profile> handle(CreateProfileCommand command) {
        var profile = new Profile(command);
        var createdProfile = profileRepository.save(profile);
        return Optional.of(createdProfile);
    }
}
