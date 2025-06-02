package com.crud.exercicio.biblioteca.controllers.dtos;

import com.crud.exercicio.biblioteca.entities.BookDetail;

public record BookDetailDto(
        Long id,
        String summary,
        Integer pageCount,
        String year,
        String isbn) {

  public static BookDetailDto toDto(BookDetail bookDetail) {
    return new BookDetailDto(
            bookDetail.getId(),
            bookDetail.getSummary(),
            bookDetail.getPageCount(),
            bookDetail.getYear(),
            bookDetail.getIsbn()
    );
  }
}
