package com.juniors.sporteaseplatform.categories.domain.model.commands;

public record CreateCategoryCommand(String nameProfessor, Integer yearCategory) {
    public CreateCategoryCommand {
        if(nameProfessor ==null || nameProfessor.isBlank()){
            throw new IllegalArgumentException("nameProfessor is null or empty");
        }
        if(yearCategory==null){
            throw new IllegalArgumentException("yearCategory is null");
        }
    }
}
