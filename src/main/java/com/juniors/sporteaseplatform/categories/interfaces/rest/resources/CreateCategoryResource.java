package com.juniors.sporteaseplatform.categories.interfaces.rest.resources;

public record CreateCategoryResource(String nameProfessor, Integer yearCategory) {
    public CreateCategoryResource {
        if(nameProfessor ==null){
            throw new IllegalArgumentException("nameProfessor cannot be null");
        }
        if(yearCategory==null){
            throw new IllegalArgumentException("yearCategory cannot be null");
        }
    }
}
