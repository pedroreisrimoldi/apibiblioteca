package com.crud.exercicio.biblioteca.controllers.dtos;

import com.crud.exercicio.biblioteca.entities.Publisher;

public record PublisherDto(Long id, String name, String address) {

  public static PublisherDto toDto(Publisher publisher) {
    return new PublisherDto(
      publisher.getId(),
      publisher.getName(),
      publisher.getAddress()
    );
  }
}
