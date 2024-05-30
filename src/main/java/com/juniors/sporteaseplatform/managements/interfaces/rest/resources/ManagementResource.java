package com.juniors.sporteaseplatform.managements.interfaces.rest.resources;

public record ManagementResource(Long id, String name, String lastName, String email, String password,
                                 String type, String nameClub) {
}
