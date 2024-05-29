package com.juniors.sporteaseplatform.profiles.interfaces.rest.resources;

public record CreateProfileResource(String name, String lastName, String email, String password, String type) {
    public CreateProfileResource{
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
    }
}
