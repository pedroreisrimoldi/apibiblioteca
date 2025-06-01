package com.crud.exercicio.biblioteca.controllers;

import com.crud.exercicio.biblioteca.entities.Book;
import com.crud.exercicio.biblioteca.services.BookService;
import com.crud.exercicio.biblioteca.services.exceptions.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/books")
public class BookController {
  private final BookService bookService;

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Book> findById(@PathVariable Long id) throws BookNotFoundException {
    Book book = bookService.findById(id);
    return ResponseEntity.ok(book);
  }
}
