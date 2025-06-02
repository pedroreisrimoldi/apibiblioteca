package com.crud.exercicio.biblioteca.controllers;

import com.crud.exercicio.biblioteca.controllers.dtos.AuthorCreationDto;
import com.crud.exercicio.biblioteca.controllers.dtos.AuthorDto;
import com.crud.exercicio.biblioteca.entities.Author;
import com.crud.exercicio.biblioteca.services.AuthorService;
import com.crud.exercicio.biblioteca.services.exceptions.AuthorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {
  private final AuthorService authorService;

  @Autowired
  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @GetMapping("/{id}")
  public AuthorDto getAuthorById(@PathVariable Long id) throws AuthorNotFoundException {
    return AuthorDto.toDto(
            authorService.findById(id)
    );
  }

  @GetMapping
  public List<AuthorDto> getAllAuthors() {
    List<Author> allAuthors = authorService.findAll();
    return allAuthors.stream()
            .map(AuthorDto::toDto)
            .toList();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public AuthorDto createAuthor(@RequestBody AuthorCreationDto authorCreationDto) {
    return AuthorDto.toDto(
            authorService.create(authorCreationDto.toEntity())
    );
  }

  @PutMapping("/{id}")
  public AuthorDto updateAuthor(@PathVariable Long id,
                                @RequestBody AuthorCreationDto authorCreationDto) throws AuthorNotFoundException {
    return AuthorDto.toDto(
            authorService.update(id, authorCreationDto.toEntity())
    );
  }

  @DeleteMapping("/{id}")
  public AuthorDto deleteAuthorById(@PathVariable Long id) throws AuthorNotFoundException {
    return AuthorDto.toDto(
            authorService.deleteById(id)
    );
  }
}
