package com.crud.exercicio.biblioteca.controllers.dtos;

import com.crud.exercicio.biblioteca.entities.Publisher;

public record PublisherCreationDto(String name, String address) {

  public Publisher toEntity() {
    return new Publisher(name, address);
  }
}
