package com.dmggg.curso_spring_crud_v3.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dmggg.curso_spring_crud_v3.dto.CategoryDTO;
import com.dmggg.curso_spring_crud_v3.services.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

  @Autowired
  private CategoryService service;
  
  @GetMapping
  public ResponseEntity<List<CategoryDTO>> find_all(){
    List<CategoryDTO> list = service.find_all();
    
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<CategoryDTO> find_by_id(@PathVariable long id){
    return ResponseEntity.ok().body(service.find_by_id(id));
  }

  @PostMapping(value = "/add/{dto}")
  public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO dto) {
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path()
    dto = insert(dto);
  }
  
}
