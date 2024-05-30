package com.juniors.sporteaseplatform.managements.interfaces.rest;

import com.juniors.sporteaseplatform.managements.domain.model.aggregates.Management;
import com.juniors.sporteaseplatform.managements.domain.model.queries.GetAllManagementByTypeQuery;
import com.juniors.sporteaseplatform.managements.domain.model.queries.GetAllManagementQuery;
import com.juniors.sporteaseplatform.managements.domain.services.ManagementCommandService;
import com.juniors.sporteaseplatform.managements.domain.services.ManagementQueryService;
import com.juniors.sporteaseplatform.managements.interfaces.rest.resources.CreateManagementResource;
import com.juniors.sporteaseplatform.managements.interfaces.rest.resources.ManagementResource;
import com.juniors.sporteaseplatform.managements.interfaces.rest.transform.CreateManagementCommandFromResourceAssembler;
import com.juniors.sporteaseplatform.managements.interfaces.rest.transform.ManagementResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/managements")
// CAMBIARLO POR LO QUE TENEMOS EN EL base.service DE FRONTEND, LOS ENDPOINTS QUE USAMOS para no cambiar el del frontend cuando integremos
public class ManagementController {
    private final ManagementCommandService managementCommandService;
    private final ManagementQueryService managementQueryService;

    public ManagementController(ManagementCommandService managementCommandService, ManagementQueryService managementQueryService) {
        this.managementCommandService = managementCommandService;
        this.managementQueryService = managementQueryService;
    }

    @PostMapping
    public ResponseEntity<ManagementResource> createManagement(@RequestBody CreateManagementResource resource) {
        Optional<Management> management = managementCommandService.
                handle(CreateManagementCommandFromResourceAssembler.toCommandFromResource(resource));
        return management.map(source -> new ResponseEntity<>(
                        ManagementResourceFromEntityAssembler.toResourceFromEntity(source),CREATED)).
                orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @GetMapping("{type}")
    public ResponseEntity<List<ManagementResource>> getManagementByType(@PathVariable String type) {
        var getAllManagementByTypeQuery = new GetAllManagementByTypeQuery(type);
        var management = managementQueryService.handle(getAllManagementByTypeQuery);
        if (management.isEmpty()) return ResponseEntity.notFound().build();
        var managementResources = management.stream().map(
                ManagementResourceFromEntityAssembler:: toResourceFromEntity).toList();
        return ResponseEntity.ok(managementResources);
    }

    @GetMapping
    public ResponseEntity<List<ManagementResource>> getAllManagement() {
        var getAllManagementQuery = new GetAllManagementQuery();
        var management = managementQueryService.handle(getAllManagementQuery);
        if (management.isEmpty()) return ResponseEntity.notFound().build();
        var managementResources = management.stream().map(
                ManagementResourceFromEntityAssembler:: toResourceFromEntity).toList();
        return ResponseEntity.ok(managementResources);
    }
}
