package com.bookstore.book.services.category;
import com.bookstore.book.model.category.Category;
import com.bookstore.book.model.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices {
    @Autowired
    CategoryRepository categoryRepository;
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
