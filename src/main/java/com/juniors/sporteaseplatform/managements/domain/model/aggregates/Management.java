package com.juniors.sporteaseplatform.managements.domain.model.aggregates;

import com.juniors.sporteaseplatform.managements.domain.model.commands.CreateManagementCommand;
import com.juniors.sporteaseplatform.shared.domain.model.aggregates.PersonAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Management extends PersonAbstractAggregateRoot<Management> {

    @Column(nullable = false)
    @Getter
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
}
