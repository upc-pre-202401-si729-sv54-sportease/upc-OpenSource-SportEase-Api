package com.juniors.sporteaseplatform.managements.domain.model.aggregates;

import com.juniors.sporteaseplatform.managements.domain.model.commands.CreateManagementCommand;
import com.juniors.sporteaseplatform.managements.domain.model.commands.UpdateManagementCommand;
import com.juniors.sporteaseplatform.shared.domain.model.aggregates.PersonAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Management extends PersonAbstractAggregateRoot<Management> {

    @Column(nullable = false)
    private String nameClub;

    // NO ESTOY AGREGANDO "nameSport" porque creo que no lo usamos en ningun momento
    // ya si lo consideran necesario lo agregan

    protected Management(){}

    public Management(CreateManagementCommand command){
        this.name = command.name();
        this.lastName = command.lastName();
        this.email = command.email();
        this.password = command.password();
        this.type = command.type();
        this.nameClub = command.nameClub();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

}
