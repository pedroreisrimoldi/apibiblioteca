package com.crud.exercicio.biblioteca.controllers.dtos;

import com.crud.exercicio.biblioteca.entities.BookDetail;

public record BookDetailCreationDto(
        String summary,
        Integer pageCount,
        String year,
        String isbn) {

  public BookDetail toEntity() {
    return new BookDetail(summary, pageCount, year, isbn);
  }
}