package com.crud.exercicio.biblioteca.controllers.dtos;

import com.crud.exercicio.biblioteca.entities.Book;

public record BookCreationDto(String title, String genre) {

  public Book toEntity() {
    return new Book(title, genre);
  }
}
