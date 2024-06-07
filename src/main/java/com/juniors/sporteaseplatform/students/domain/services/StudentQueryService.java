package com.juniors.sporteaseplatform.students.domain.services;

import com.juniors.sporteaseplatform.students.domain.model.aggregates.Student;
import com.juniors.sporteaseplatform.students.domain.model.queries.GetAllStudentByCategoryQuery;
import com.juniors.sporteaseplatform.students.domain.model.queries.GetAllStudentQuery;

import java.util.List;

public interface StudentQueryService {
    List<Student> handle(GetAllStudentByCategoryQuery query);
    List<Student> handle(GetAllStudentQuery query);
}
