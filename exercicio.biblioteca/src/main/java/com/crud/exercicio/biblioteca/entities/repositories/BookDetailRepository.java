package com.crud.exercicio.biblioteca.entities.repositories;

import com.crud.exercicio.biblioteca.entities.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDetailRepository extends JpaRepository<BookDetail, Long> {
}
