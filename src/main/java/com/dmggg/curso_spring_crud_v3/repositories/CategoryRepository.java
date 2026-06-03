package com.dmggg.curso_spring_crud_v3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmggg.curso_spring_crud_v3.entities.Category;

@Repository  
public interface CategoryRepository extends JpaRepository<Category, Long> {
  
}
