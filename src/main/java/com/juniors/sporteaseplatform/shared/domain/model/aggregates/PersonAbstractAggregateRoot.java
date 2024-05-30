package com.juniors.sporteaseplatform.shared.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class PersonAbstractAggregateRoot<T extends AbstractAggregateRoot<T>> extends AbstractAggregateRoot<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter
    protected String name;

    @Column(nullable = false)
    @Getter
    protected String lastName;

    // Deberia ir email y password en el IAM?(gestión de identidades y accesos)
    @Column(nullable = false)
    @Getter
    @Email
    protected String email;

    @Column(nullable = false)
    @Getter
    protected String password;

    @Column(nullable = false)
    @Getter
    protected String type;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;
}
