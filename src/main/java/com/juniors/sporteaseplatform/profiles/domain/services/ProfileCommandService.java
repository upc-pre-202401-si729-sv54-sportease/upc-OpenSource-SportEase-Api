package com.juniors.sporteaseplatform.profiles.domain.services;

import com.juniors.sporteaseplatform.profiles.domain.model.aggregates.Profile;
import com.juniors.sporteaseplatform.profiles.domain.model.commands.CreateProfileCommand;

import java.util.Optional;

public interface ProfileCommandService {
    Optional<Profile> handle(CreateProfileCommand command);
}
