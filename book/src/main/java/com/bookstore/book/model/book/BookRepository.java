package com.bookstore.book.model.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Optional<Book> findByName(String name);
    List<Book> findByAutorContaining(String autor);
    List<Book> findBookByCategory_Name(String categoria);
    List<Book> findByFechaPublicacionBetween(Date fechaInicio, Date fechaFin);
    List<Book> findByOrderByFechaPublicacionDesc();
    List<Book> findByNombreContaining(String nombre);

}
