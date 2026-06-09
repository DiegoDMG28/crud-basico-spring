package com.dmggg.curso_spring_crud_v3.services.exceptions;

public class DatabaseException extends RuntimeException {
  public DatabaseException(String msg){
    super(msg);
  }
}
