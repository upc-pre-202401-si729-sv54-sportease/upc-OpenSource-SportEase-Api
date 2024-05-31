package com.juniors.sporteaseplatform.managements.application.internal.commandservices;

import com.juniors.sporteaseplatform.managements.domain.model.aggregates.Student;
import com.juniors.sporteaseplatform.managements.domain.model.commands.CreateStudentCommand;
import com.juniors.sporteaseplatform.managements.domain.services.StudentCommandService;
import com.juniors.sporteaseplatform.managements.infraestructure.persistance.jpa.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentCommandServiceImpl implements StudentCommandService {
    private final StudentRepository studentRepository;

    public StudentCommandServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Optional<Student> handle(CreateStudentCommand command) {
        var student = new Student(command);
        var createdStudent = studentRepository.save(student);
        return Optional.of(createdStudent);
    }
}
