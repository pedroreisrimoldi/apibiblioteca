package com.crud.exercicio.biblioteca.controllers;

import com.crud.exercicio.biblioteca.controllers.dtos.PublisherCreationDto;
import com.crud.exercicio.biblioteca.controllers.dtos.PublisherDto;
import com.crud.exercicio.biblioteca.entities.Publisher;
import com.crud.exercicio.biblioteca.services.PublisherService;
import com.crud.exercicio.biblioteca.services.exceptions.PublisherNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/publishers")
public class PublisherController {
  private final PublisherService publisherService;

  @Autowired
  public PublisherController(PublisherService publisherService) {
    this.publisherService = publisherService;
  }

  @GetMapping("/{id}")
  public PublisherDto getPublisherById(@PathVariable Long id) throws PublisherNotFoundException {
    return PublisherDto.toDto(
            publisherService.findById(id)
    );
  }

  @GetMapping
  public List<PublisherDto> getAllPublishers() {
    List<Publisher> allPublishers = publisherService.findAll();
    return allPublishers.stream()
            .map(PublisherDto::toDto)
            .toList();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PublisherDto createPublisher(@RequestBody PublisherCreationDto publisherCreationDto) {
    return PublisherDto.toDto(
            publisherService.create(publisherCreationDto.toEntity())
    );
  }

  @PutMapping("/{id}")
  public PublisherDto updatePublisher(@PathVariable Long id,
                                      @RequestBody PublisherCreationDto publisherCreationDto) throws PublisherNotFoundException {
    return PublisherDto.toDto(
            publisherService.update(id, publisherCreationDto.toEntity())
    );
  }

  @DeleteMapping("/{id}")
  public PublisherDto deletePublisherById(@PathVariable Long id) throws PublisherNotFoundException {
    return PublisherDto.toDto(
            publisherService.deleteById(id)
    );
  }
}
