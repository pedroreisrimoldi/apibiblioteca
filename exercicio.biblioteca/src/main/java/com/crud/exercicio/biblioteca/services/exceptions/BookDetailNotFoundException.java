package com.crud.exercicio.biblioteca.services.exceptions;

public class BookDetailNotFoundException extends NotFoundException {
  public BookDetailNotFoundException() {
    super("Detalhes do livro não encontrados");
  }
}
