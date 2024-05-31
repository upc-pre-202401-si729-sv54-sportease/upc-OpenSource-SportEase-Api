package com.juniors.sporteaseplatform.managements.domain.model.aggregates;

import com.juniors.sporteaseplatform.managements.domain.model.commands.CreateStudentCommand;
import com.juniors.sporteaseplatform.shared.domain.model.aggregates.PersonAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Student extends PersonAbstractAggregateRoot<Student> {

    @Column(nullable = false)
    @Getter
    private Integer category;

    protected Student(){}

    public Student(CreateStudentCommand command){
        this.name = command.name();
        this.lastName = command.lastName();
        this.email = command.email();
        this.password = command.password();
        this.type = command.type();
        this.category = command.category();
    }
}
