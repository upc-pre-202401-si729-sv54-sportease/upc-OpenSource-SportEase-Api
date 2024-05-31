package com.juniors.sporteaseplatform.managements.domain.model.commands;

public record CreateStudentCommand(String name, String lastName, String email, String password,
                                   String type, Integer category) {
    public CreateStudentCommand {
        if(name ==null || name.isBlank()){
            throw new IllegalArgumentException("name is null or empty");
        }
        if(lastName==null || lastName.isBlank()){
            throw new IllegalArgumentException("lastName is null or empty");
        }
        if(email ==null || email.isBlank()){
            throw new IllegalArgumentException("email is null or empty");
        }
        if(password==null || password.isBlank()){
            throw new IllegalArgumentException("password is null or empty");
        }
        if(type==null || type.isBlank()){
            throw new IllegalArgumentException("type is null or empty");
        }
        if(category==null){
            throw new IllegalArgumentException("category is null");
        }
    }
}
