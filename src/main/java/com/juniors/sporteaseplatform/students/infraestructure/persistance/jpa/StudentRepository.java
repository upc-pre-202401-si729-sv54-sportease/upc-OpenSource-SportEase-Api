package com.juniors.sporteaseplatform.students.infraestructure.persistance.jpa;

import com.juniors.sporteaseplatform.students.domain.model.aggregates.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByCategory(Integer category);
}