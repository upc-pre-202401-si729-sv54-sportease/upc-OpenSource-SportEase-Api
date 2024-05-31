package com.juniors.sporteaseplatform.managements.interfaces.rest.resources;

public record CreateStudentResource(String name, String lastName, String email, String password,
                                    String type, Integer category) {
    public CreateStudentResource {
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
        if(category==null){
            throw new IllegalArgumentException("category cannot be null");
        }
    }
}
