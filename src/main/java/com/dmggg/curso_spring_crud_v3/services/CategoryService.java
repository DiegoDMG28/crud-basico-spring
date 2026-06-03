package com.dmggg.curso_spring_crud_v3.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dmggg.curso_spring_crud_v3.dto.CategoryDTO;
import com.dmggg.curso_spring_crud_v3.entities.Category;
import com.dmggg.curso_spring_crud_v3.repositories.CategoryRepository;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository repository;
  
  @Transactional(readOnly = true)
  public List<CategoryDTO> find_all(){
    List<Category> list = repository.findAll();
    List<CategoryDTO> listDTO = new ArrayList<>();

    for(Category category: list){
      listDTO.add(new CategoryDTO(category));
    }

    return listDTO;
  };

  @Transactional(readOnly = true)
  public CategoryDTO find_by_id(long id){
    Optional<Category> category = repository.findById(id);
    CategoryDTO categoryDTO = new CategoryDTO(category.get());

    return categoryDTO;
  }

}
