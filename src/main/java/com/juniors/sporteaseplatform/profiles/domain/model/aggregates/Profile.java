package com.juniors.sporteaseplatform.profiles.domain.model.aggregates;

import com.juniors.sporteaseplatform.profiles.domain.model.commands.CreateProfileCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter
    private String name;

    @Column(nullable = false)
    @Getter
    private String lastName;

    // Deberia ir email y password en el IAM?(gestión de identidades y accesos)
    @Column(nullable = false)
    @Getter
    private String email;

    @Column(nullable = false)
    @Getter
    private String password;

    @Column(nullable = false)
    @Getter
    private String type;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    protected Profile(){}

    public Profile(CreateProfileCommand command){
        this.name = command.name();
        this.lastName = command.lastName();
        this.email = command.email();
        this.password = command.password();
        this.type = command.type();
    }
}
