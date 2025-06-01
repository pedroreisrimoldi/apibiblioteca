package com.crud.exercicio.biblioteca.services;

import com.crud.exercicio.biblioteca.entities.Book;
import com.crud.exercicio.biblioteca.entities.repositories.BookRepository;
import com.crud.exercicio.biblioteca.services.exceptions.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  private final BookRepository bookRepository;

  @Autowired
  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public Book findById(Long id) throws BookNotFoundException {
    return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
  }


}
