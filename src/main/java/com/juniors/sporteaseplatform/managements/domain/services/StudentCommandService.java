package com.juniors.sporteaseplatform.managements.domain.services;

import com.juniors.sporteaseplatform.managements.domain.model.aggregates.Student;
import com.juniors.sporteaseplatform.managements.domain.model.commands.CreateStudentCommand;

import java.util.Optional;

public interface StudentCommandService {
    Optional<Student> handle(CreateStudentCommand command);
}
