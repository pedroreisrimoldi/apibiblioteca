package com.crud.exercicio.biblioteca.controllers.dtos;

import com.crud.exercicio.biblioteca.entities.Author;

public record AuthorDto(Long id, String name, String nationality) {

  public static AuthorDto toDto(Author author) {
    return new AuthorDto(
            author.getId(),
            author.getName(),
            author.getNationality()
    );
  }
}
