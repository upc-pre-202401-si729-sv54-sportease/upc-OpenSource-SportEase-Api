package com.juniors.sporteaseplatform.students.domain.services;

import com.juniors.sporteaseplatform.students.domain.model.aggregates.Student;
import com.juniors.sporteaseplatform.students.domain.model.commands.CreateStudentCommand;

import java.util.Optional;

public interface StudentCommandService {
    Optional<Student> handle(CreateStudentCommand command);
}
