package com.crud.exercicio.biblioteca.controllers.dtos;

import com.crud.exercicio.biblioteca.entities.Author;

public record AuthorCreationDto(String name, String nationality) {

  public Author toEntity() {
    return new Author(name, nationality);
  }
}
