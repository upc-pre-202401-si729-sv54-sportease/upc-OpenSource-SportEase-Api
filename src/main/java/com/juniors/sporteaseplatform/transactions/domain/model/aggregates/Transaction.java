package com.juniors.sporteaseplatform.transactions.domain.model.aggregates;

import com.juniors.sporteaseplatform.transactions.domain.model.commands.CreateTransactionCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    @Getter
    private Date publication;

    @Column(nullable = false)
    @Getter
    private Date expiration;

    protected Transaction(){}

    public Transaction(CreateTransactionCommand command){
        this.expiration = command.expiration();
    }
}
