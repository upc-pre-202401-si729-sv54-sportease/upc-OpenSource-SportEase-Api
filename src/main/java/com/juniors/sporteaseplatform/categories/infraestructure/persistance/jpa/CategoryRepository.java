package com.juniors.sporteaseplatform.categories.infraestructure.persistance.jpa;

import com.juniors.sporteaseplatform.categories.domain.model.aggregates.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findById(Long id);
    List<Category> findAllByYearCategory(Integer yearCategory);
}