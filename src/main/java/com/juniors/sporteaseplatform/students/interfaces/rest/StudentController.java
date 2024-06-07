package com.juniors.sporteaseplatform.students.interfaces.rest;

import com.juniors.sporteaseplatform.students.domain.model.aggregates.Student;
import com.juniors.sporteaseplatform.students.domain.model.queries.GetAllStudentByCategoryQuery;
import com.juniors.sporteaseplatform.students.domain.model.queries.GetAllStudentQuery;
import com.juniors.sporteaseplatform.students.domain.services.StudentCommandService;
import com.juniors.sporteaseplatform.students.domain.services.StudentQueryService;
import com.juniors.sporteaseplatform.students.interfaces.rest.resources.CreateStudentResource;
import com.juniors.sporteaseplatform.students.interfaces.rest.resources.StudentResource;
import com.juniors.sporteaseplatform.students.interfaces.rest.transform.CreateStudentCommandFromResourceAssembler;
import com.juniors.sporteaseplatform.students.interfaces.rest.transform.StudentResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/students")
// CAMBIARLO POR LO QUE TENEMOS EN EL base.service DE FRONTEND, LOS ENDPOINTS QUE USAMOS para no cambiar el del frontend cuando integremos
public class StudentController {
    private final StudentCommandService studentCommandService;
    private final StudentQueryService studentQueryService;

    public StudentController(StudentCommandService studentCommandService, StudentQueryService studentQueryService) {
        this.studentCommandService = studentCommandService;
        this.studentQueryService = studentQueryService;
    }

    @PostMapping
    public ResponseEntity<StudentResource> createStudent(@RequestBody CreateStudentResource resource) {
        Optional<Student> student = studentCommandService.
                handle(CreateStudentCommandFromResourceAssembler.toCommandFromResource(resource));
        return student.map(source -> new ResponseEntity<>(
                        StudentResourceFromEntityAssembler.toResourceFromEntity(source),CREATED)).
                orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @GetMapping("{category}")
    public ResponseEntity<List<StudentResource>> getStudentByCategory(@PathVariable Integer category) {
        var getAllStudentByCategoryQuery = new GetAllStudentByCategoryQuery(category);
        var student = studentQueryService.handle(getAllStudentByCategoryQuery);
        if (student.isEmpty()) return ResponseEntity.notFound().build();
        var studentResources = student.stream().map(
                StudentResourceFromEntityAssembler:: toResourceFromEntity).toList();
        return ResponseEntity.ok(studentResources);
    }

    @GetMapping
    public ResponseEntity<List<StudentResource>> getAllStudent() {
        var getAllStudentQuery = new GetAllStudentQuery();
        var student = studentQueryService.handle(getAllStudentQuery);
        if (student.isEmpty()) return ResponseEntity.notFound().build();
        var studentResources = student.stream().map(
                StudentResourceFromEntityAssembler:: toResourceFromEntity).toList();
        return ResponseEntity.ok(studentResources);
    }
}
