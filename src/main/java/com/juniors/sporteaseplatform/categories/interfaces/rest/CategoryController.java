package com.juniors.sporteaseplatform.categories.interfaces.rest;

import com.juniors.sporteaseplatform.categories.domain.model.aggregates.Category;
import com.juniors.sporteaseplatform.categories.domain.model.queries.GetAllCategoryByYearCategoryQuery;
import com.juniors.sporteaseplatform.categories.domain.model.queries.GetCategoryByIdQuery;
import com.juniors.sporteaseplatform.categories.domain.model.queries.GetAllCategoryQuery;
import com.juniors.sporteaseplatform.categories.domain.services.CategoryCommandService;
import com.juniors.sporteaseplatform.categories.domain.services.CategoryQueryService;
import com.juniors.sporteaseplatform.categories.interfaces.rest.resources.CreateCategoryResource;
import com.juniors.sporteaseplatform.categories.interfaces.rest.resources.CategoryResource;
import com.juniors.sporteaseplatform.categories.interfaces.rest.transform.CreateCategoryCommandFromResourceAssembler;
import com.juniors.sporteaseplatform.categories.interfaces.rest.transform.CategoryResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/category")
// CAMBIARLO POR LO QUE TENEMOS EN EL base.service DE FRONTEND, LOS ENDPOINTS QUE USAMOS para no cambiar el del frontend cuando integremos
public class CategoryController {
    private final CategoryCommandService categoryCommandService;
    private final CategoryQueryService categoryQueryService;

    public CategoryController(CategoryCommandService categoryCommandService, CategoryQueryService categoryQueryService) {
        this.categoryCommandService = categoryCommandService;
        this.categoryQueryService = categoryQueryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResource> createCategory(@RequestBody CreateCategoryResource resource) {
        Optional<Category> category = categoryCommandService.
                handle(CreateCategoryCommandFromResourceAssembler.toCommandFromResource(resource));
        return category.map(source -> new ResponseEntity<>(
                        CategoryResourceFromEntityAssembler.toResourceFromEntity(source),CREATED)).
                orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CategoryResource> getCategoryById(@PathVariable Long id) {
        Optional<Category> category = categoryQueryService.handle(new GetCategoryByIdQuery(id));
        return category.map(source -> ResponseEntity.ok(CategoryResourceFromEntityAssembler.
                        toResourceFromEntity(source))).
                orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/year/{yearCategory}")
    public ResponseEntity<List<CategoryResource>> getCategoryByYearCategory(@PathVariable Integer yearCategory) {
        var getAllCategoryByYearCategoryQuery = new GetAllCategoryByYearCategoryQuery(yearCategory);
        var category = categoryQueryService.handle(getAllCategoryByYearCategoryQuery);
        if (category.isEmpty()) return ResponseEntity.notFound().build();
        var categoryResources = category.stream().map(
                CategoryResourceFromEntityAssembler:: toResourceFromEntity).toList();
        return ResponseEntity.ok(categoryResources);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResource>> getAllCategory() {
        var getAllCategoryQuery = new GetAllCategoryQuery();
        var category = categoryQueryService.handle(getAllCategoryQuery);
        if (category.isEmpty()) return ResponseEntity.notFound().build();
        var categoryResources = category.stream().map(
                CategoryResourceFromEntityAssembler:: toResourceFromEntity).toList();
        return ResponseEntity.ok(categoryResources);
    }
}
