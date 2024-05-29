package com.juniors.sporteaseplatform.profiles.infraestructure.persistance.jpa;

import com.juniors.sporteaseplatform.profiles.domain.model.aggregates.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository   extends JpaRepository<Profile, Long> {
    List<Profile> findAllByType(String type);
}