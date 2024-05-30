package com.juniors.sporteaseplatform.managements.interfaces.rest.resources;

public record CreateManagementResource(String name, String lastName, String email, String password,
                                       String type, String nameClub) {
    public CreateManagementResource {
        if(name ==null){
            throw new IllegalArgumentException("name cannot be null");
        }
        if(lastName==null){
            throw new IllegalArgumentException("lastName cannot be null");
        }
        if(email ==null){
            throw new IllegalArgumentException("email cannot be null");
        }
        if(password==null){
            throw new IllegalArgumentException("password cannot be null");
        }
        if(type==null){
            throw new IllegalArgumentException("type cannot be null");
        }
        if(nameClub==null){
            throw new IllegalArgumentException("nameClub cannot be null");
        }
    }
}
