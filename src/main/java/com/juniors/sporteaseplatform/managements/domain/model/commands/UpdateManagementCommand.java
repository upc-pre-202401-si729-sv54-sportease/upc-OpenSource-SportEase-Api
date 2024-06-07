package com.juniors.sporteaseplatform.managements.domain.model.commands;

public record UpdateManagementCommand(Long id, String name, String lastName, String email, String password,
                                      String type, String nameClub) {
    public UpdateManagementCommand {
        if (id == null) {
            throw new IllegalArgumentException("id is null");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is null or empty");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("lastName is null or empty");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("email is null or empty");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("password is null or empty");
        }
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("type is null or empty");
        }
        if (nameClub == null || nameClub.isBlank()) {
            throw new IllegalArgumentException("nameClub is null or empty");
        }
    }
}

