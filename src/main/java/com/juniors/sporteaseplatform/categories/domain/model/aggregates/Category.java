package com.juniors.sporteaseplatform.categories.domain.model.aggregates;

import com.juniors.sporteaseplatform.categories.domain.model.commands.CreateCategoryCommand;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Category{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter
    private String nameProfessor;

    @Column(nullable = false)
    @Getter
    private Integer yearCategory;

    protected Category(){}

    public Category(CreateCategoryCommand command){
        this.nameProfessor = command.nameProfessor();
        this.yearCategory = command.yearCategory();
    }
}
