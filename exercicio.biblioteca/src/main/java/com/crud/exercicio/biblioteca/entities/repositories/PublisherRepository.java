package com.crud.exercicio.biblioteca.entities.repositories;

import com.crud.exercicio.biblioteca.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
