package com.crud.exercicio.biblioteca.services.exceptions;

public class PublisherNotFoundException extends NotFoundException {
  public PublisherNotFoundException() {
    super("Editora não encontrada");
  }
}
