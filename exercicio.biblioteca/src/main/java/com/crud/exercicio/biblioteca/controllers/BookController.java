package com.crud.exercicio.biblioteca.controllers;

import com.crud.exercicio.biblioteca.controllers.dtos.BookCreationDto;
import com.crud.exercicio.biblioteca.controllers.dtos.BookDetailCreationDto;
import com.crud.exercicio.biblioteca.controllers.dtos.BookDetailDto;
import com.crud.exercicio.biblioteca.controllers.dtos.BookDto;
import com.crud.exercicio.biblioteca.entities.Book;
import com.crud.exercicio.biblioteca.services.BookService;
import com.crud.exercicio.biblioteca.services.exceptions.BookDetailNotFoundException;
import com.crud.exercicio.biblioteca.services.exceptions.BookNotFoundException;
import com.crud.exercicio.biblioteca.services.exceptions.PublisherNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {
  private final BookService bookService;

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookDto> findById(@PathVariable Long id)
          throws BookNotFoundException {
    Book book = bookService.findById(id);
    return ResponseEntity.ok(BookDto.toDto(book));
  }

  @GetMapping
  public ResponseEntity<List<BookDto>> getAllBooks() {
    List<Book> allBooks = bookService.findAll();

    return ResponseEntity.ok(allBooks.stream()
            .map(BookDto::toDto).toList());
  }

  @PostMapping
  public ResponseEntity<BookDto> createBook(
          @RequestBody BookCreationDto bookCreationDto
  ) {
    return ResponseEntity.status(HttpStatus.CREATED).body(BookDto.toDto(
            bookService.create(bookCreationDto.toEntity())
    ));
  }

  @PutMapping("/{id}")
  public ResponseEntity<BookDto> updateBook(
          @PathVariable Long id,
          @RequestBody BookCreationDto bookCreationDto
  ) throws BookNotFoundException {

    return ResponseEntity.ok(BookDto.toDto(
            bookService.update(id, bookCreationDto.toEntity())
    ));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<BookDto> deleteBookById(@PathVariable Long id)
          throws BookNotFoundException {
    return ResponseEntity.ok(BookDto.toDto(
            bookService.deleteById(id)
    ));
  }

  @PostMapping("/{bookId}/detail")
  public ResponseEntity<BookDetailDto> createBookDetail(
          @PathVariable Long bookId,
          @RequestBody BookDetailCreationDto bookDetailCreationDto
  ) throws BookNotFoundException {

    return ResponseEntity.status(HttpStatus.CREATED)
            .body(BookDetailDto.toDto(bookService
                    .createBookDetail(bookId, bookDetailCreationDto.toEntity())
    ));
  }

  @GetMapping("/{bookId}/detail")
  public ResponseEntity<BookDetailDto> getBookDetail(
          @PathVariable Long bookId
  ) throws BookNotFoundException, BookDetailNotFoundException {

    return ResponseEntity.ok(BookDetailDto.toDto(
            bookService.getBookDetail(bookId))
    );
  }

  @PutMapping("/{bookId}/detail")
  public ResponseEntity<BookDetailDto> updateBookDetail(
          @PathVariable Long bookId,
          @RequestBody BookDetailCreationDto bookDetailCreationDto
  ) throws BookDetailNotFoundException, BookNotFoundException {

    return ResponseEntity.ok(BookDetailDto
            .toDto(bookService
                    .updateBookDetail(bookId, bookDetailCreationDto.toEntity())));
  }

  @DeleteMapping("/{bookId}/detail")
  public ResponseEntity<BookDetailDto> removeBookDetail(@PathVariable Long bookId)
          throws BookDetailNotFoundException, BookNotFoundException {

    return ResponseEntity.ok(BookDetailDto
            .toDto(bookService.removeBookDetail(bookId)));
  }

  @PutMapping("/{bookId}/publisher/{publisherId}")
  public BookDto setBookPublisher(
          @PathVariable Long bookId,
          @PathVariable Long publisherId
  ) throws BookNotFoundException, PublisherNotFoundException {

    return BookDto.toDto(
            bookService.setBookPublisher(bookId, publisherId)
    );
  }

  @DeleteMapping("/{bookId}/publisher")
  public BookDto removeBookPublisher(
          @PathVariable Long bookId
  ) throws BookNotFoundException {

    return BookDto.toDto(
            bookService.removeBookPublisher(bookId)
    );
  }
}
