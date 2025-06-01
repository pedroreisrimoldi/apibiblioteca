package com.crud.exercicio.biblioteca.services.exceptions;

public class BookNotFoundException extends NotFoundException {
  public BookNotFoundException() {
    super("Livro não encontrado");
  }
}
