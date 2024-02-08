package com.bookstore.book.services;

import com.bookstore.book.model.book.Book;
import com.bookstore.book.model.book.BookRepository;
import com.bookstore.book.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public ResponseEntity<CustomResponse> getAll() {

        return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(this.bookRepository.findAll(),false,200,"OK"));
    }
    public ResponseEntity<CustomResponse> insert(Book book){

        Optional<Book> existName = bookRepository.findByName(book.getName());
        if(existName.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new CustomResponse(null, true, HttpStatus.BAD_REQUEST.value(), "El nombre del libro ya existe"));
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CustomResponse(bookRepository.save(book), false, HttpStatus.CREATED.value(), "Libro registrado"));
    }
}
