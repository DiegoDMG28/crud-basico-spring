package com.dmggg.curso_spring_crud_v3.services.exceptions;

public class EntityNotFound extends RuntimeException {
  public EntityNotFound(String msg){
    super(msg);
  }
}
