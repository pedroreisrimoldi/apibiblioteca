package com.crud.exercicio.biblioteca.controllers.dtos;

import com.crud.exercicio.biblioteca.entities.Book;

import java.util.List;

public record BookDto(
        Long id,
        String title,
        String genre,
        PublisherDto publisher,
        List<AuthorDto> authors
) {

  public static BookDto toDto(Book book) {
    PublisherDto publisherDto = book.getPublisher() != null ?
            PublisherDto.toDto(book.getPublisher()) : null;

    return new BookDto(
            book.getId(),
            book.getTitle(),
            book.getGenre(),
            publisherDto,
            book.getAuthors().stream()
                    .map(AuthorDto::toDto)
                    .toList()
    );
  }
}
