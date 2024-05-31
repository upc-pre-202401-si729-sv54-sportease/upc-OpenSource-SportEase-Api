package com.juniors.sporteaseplatform.students.interfaces.rest.transform;

import com.juniors.sporteaseplatform.students.domain.model.aggregates.Student;
import com.juniors.sporteaseplatform.students.interfaces.rest.resources.StudentResource;

public class StudentResourceFromEntityAssembler {
    public static StudentResource toResourceFromEntity(Student entity) {
        return new StudentResource(entity.getId(), entity.getName(), entity.getLastName(),
                entity.getEmail(), entity.getPassword(), entity.getType(), entity.getCategory());
    }
}
