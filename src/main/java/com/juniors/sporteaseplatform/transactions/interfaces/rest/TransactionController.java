package com.juniors.sporteaseplatform.transactions.interfaces.rest;

import com.juniors.sporteaseplatform.transactions.domain.model.aggregates.Transaction;
import com.juniors.sporteaseplatform.transactions.domain.model.queries.GetTransactionByIdQuery;
import com.juniors.sporteaseplatform.transactions.domain.model.queries.GetAllTransactionQuery;
import com.juniors.sporteaseplatform.transactions.domain.services.TransactionCommandService;
import com.juniors.sporteaseplatform.transactions.domain.services.TransactionQueryService;
import com.juniors.sporteaseplatform.transactions.interfaces.rest.resources.CreateTransactionResource;
import com.juniors.sporteaseplatform.transactions.interfaces.rest.resources.TransactionResource;
import com.juniors.sporteaseplatform.transactions.interfaces.rest.transform.CreateTransactionCommandFromResourceAssembler;
import com.juniors.sporteaseplatform.transactions.interfaces.rest.transform.TransactionResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/transaction")
// CAMBIARLO POR LO QUE TENEMOS EN EL base.service DE FRONTEND, LOS ENDPOINTS QUE USAMOS para no cambiar el del frontend cuando integremos
public class TransactionController {
    private final TransactionCommandService transactionCommandService;
    private final TransactionQueryService transactionQueryService;

    public TransactionController(TransactionCommandService transactionCommandService, TransactionQueryService transactionQueryService) {
        this.transactionCommandService = transactionCommandService;
        this.transactionQueryService = transactionQueryService;
    }

    @PostMapping
    public ResponseEntity<TransactionResource> createTransaction(@RequestBody CreateTransactionResource resource) {
        Optional<Transaction> transaction = transactionCommandService.
                handle(CreateTransactionCommandFromResourceAssembler.toCommandFromResource(resource));
        return transaction.map(source -> new ResponseEntity<>(
                        TransactionResourceFromEntityAssembler.toResourceFromEntity(source),CREATED)).
                orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<TransactionResource> getTransactionById(@PathVariable Long id) {
        Optional<Transaction> transaction = transactionQueryService.handle(new GetTransactionByIdQuery(id));
        return transaction.map(source -> ResponseEntity.ok(TransactionResourceFromEntityAssembler.
                        toResourceFromEntity(source))).
                orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<TransactionResource>> getAllTransaction() {
        var getAllTransactionQuery = new GetAllTransactionQuery();
        var transaction = transactionQueryService.handle(getAllTransactionQuery);
        if (transaction.isEmpty()) return ResponseEntity.notFound().build();
        var transactionResources = transaction.stream().map(
                TransactionResourceFromEntityAssembler:: toResourceFromEntity).toList();
        return ResponseEntity.ok(transactionResources);
    }
}
