package com.crud.exercicio.biblioteca.services.exceptions;

public class AuthorNotFoundException extends NotFoundException {
  public AuthorNotFoundException() {
    super("Autor não encontrado");
  }
}
