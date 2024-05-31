package com.juniors.sporteaseplatform.managements.infraestructure.persistance.jpa;

import com.juniors.sporteaseplatform.managements.domain.model.aggregates.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByCategory(Integer category);
}