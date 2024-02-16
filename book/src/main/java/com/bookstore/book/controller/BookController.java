package com.bookstore.book.controller;

import com.bookstore.book.model.book.Book;
import com.bookstore.book.services.BookService;
import com.bookstore.book.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@CrossOrigin("*")
public class BookController {

    @Autowired
    private BookService bookService;
    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<CustomResponse> addBook(@RequestBody Book book) {
        return bookService.insert(book);
    }
    @PostMapping(value = "/", produces = "application/json")
    public List<Book> getAll(){
        return bookService.getAll();
    }
    @GetMapping(value = "/category/{name}",produces = "application/json")
    public ResponseEntity<CustomResponse> getBookByCategory(@PathVariable("name") String name){
        return bookService.findByCategory(name);
    }
}
