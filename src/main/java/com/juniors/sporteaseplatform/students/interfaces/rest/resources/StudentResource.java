package com.juniors.sporteaseplatform.students.interfaces.rest.resources;

public record StudentResource(Long id, String name, String lastName, String email, String password,
                              String type, Integer category) {
}
