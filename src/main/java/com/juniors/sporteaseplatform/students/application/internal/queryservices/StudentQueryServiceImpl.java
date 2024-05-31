package com.juniors.sporteaseplatform.students.application.internal.queryservices;

import com.juniors.sporteaseplatform.students.domain.model.aggregates.Student;
import com.juniors.sporteaseplatform.students.domain.model.queries.GetAllStudentByCategoryQuery;
import com.juniors.sporteaseplatform.students.domain.model.queries.GetAllStudentQuery;
import com.juniors.sporteaseplatform.students.domain.services.StudentQueryService;
import com.juniors.sporteaseplatform.students.infraestructure.persistance.jpa.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentQueryServiceImpl implements StudentQueryService {

    private final StudentRepository studentRepository;

    public StudentQueryServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> handle(GetAllStudentByCategoryQuery query) {
        return studentRepository.findAllByCategory(query.category());
    }

    @Override
    public List<Student> handle(GetAllStudentQuery query) {
        return studentRepository.findAll();
    }
}
