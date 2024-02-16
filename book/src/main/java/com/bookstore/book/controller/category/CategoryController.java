package com.bookstore.book.controller.category;
import com.bookstore.book.model.category.Category;
import com.bookstore.book.services.category.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin("*")
public class CategoryController {
@Autowired
    CategoryServices categoryServices;
    @GetMapping(value = "/", produces = "application/json")
    public List<Category> getAll(){
        return categoryServices.getAll();
    }
}
