package com.dmggg.curso_spring_crud_v3.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dmggg.curso_spring_crud_v3.dto.CategoryDTO;
import com.dmggg.curso_spring_crud_v3.entities.Category;
import com.dmggg.curso_spring_crud_v3.repositories.CategoryRepository;
import com.dmggg.curso_spring_crud_v3.services.exceptions.DatabaseException;
import com.dmggg.curso_spring_crud_v3.services.exceptions.EntityNotFound;

import jakarta.persistence.EntityNotFoundException;

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
  public Page<CategoryDTO> find_all_paged(PageRequest pageRequest){
    Page<Category> list = repository.findAll(pageRequest);
    Page<CategoryDTO> listDTO = list.map(x -> new CategoryDTO(x)); 

    return listDTO;
  };



  @Transactional(readOnly = true)
  public CategoryDTO find_by_id(long id){
    Optional<Category> category = repository.findById(id);
    CategoryDTO categoryDTO = new CategoryDTO(category.orElseThrow(() -> 
      new EntityNotFound("entity not found")));

    return categoryDTO;
  }



  @Transactional
  public CategoryDTO insert(CategoryDTO dto){
    Category entity = new Category();
    entity.setNome(dto.getNome());
     
    entity = repository.save(entity);
    return new CategoryDTO(entity);
  }



  @Transactional
  public CategoryDTO update(CategoryDTO dto, Long id){
    try{
    Category entity = repository.getReferenceById(id);
    entity.setNome(dto.getNome());
    entity = repository.save(entity);
    return new CategoryDTO(entity);
    }
    catch(EntityNotFoundException e){
      throw new EntityNotFound("id não encontrado em nosso banco de dados, id: " + id);
    }
  }



  public void delete(Long id){
    if(!repository.existsById(id)){
      throw new EntityNotFound("id não encontrado em nosso banco de dados, id: " + id);
    }
    try{
    repository.deleteById(id);
    }
    catch(DataIntegrityViolationException e){
      throw new DatabaseException("Integrity violation");
    }
  }

}
