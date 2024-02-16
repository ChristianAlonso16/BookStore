package com.bookstore.book.services.book;

import com.bookstore.book.model.book.Book;
import com.bookstore.book.model.book.BookRepository;
import com.bookstore.book.model.category.Category;
import com.bookstore.book.model.category.CategoryRepository;
import com.bookstore.book.utils.CustomResponse;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CategoryRepository categoryRepository;
    public List<Book> getAll() {
        return bookRepository.findAll();
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
    public ResponseEntity<CustomResponse> update(Book book){

        Optional<Book> exist = bookRepository.findById(book.getId());
        if(!exist.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new CustomResponse(null, true, HttpStatus.NOT_FOUND.value(), "Libro invalido"));
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CustomResponse(bookRepository.saveAndFlush(book), false, HttpStatus.CREATED.value(), "Libro actualizado"));
    }
    public ResponseEntity<CustomResponse> deleteOne(Integer id){

        Optional<Book> exist = bookRepository.findById(id);
        if(!exist.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new CustomResponse(null, true, HttpStatus.NOT_FOUND.value(), "Libro invalido"));
        }
        bookRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CustomResponse(null, false, HttpStatus.CREATED.value(), "Libro eliminado"));
    }
    public ResponseEntity<CustomResponse> findByCategory(String category){
        boolean existCategory = categoryRepository.existsByName(category);
        if (!existCategory) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomResponse(null, true, HttpStatus.NOT_FOUND.value(), "La categoria no es valida"));
        }
      return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse(bookRepository.findBookByCategory_Name(category),false,HttpStatus.OK.value(), "Libros de categoria "+category));
    }
}
