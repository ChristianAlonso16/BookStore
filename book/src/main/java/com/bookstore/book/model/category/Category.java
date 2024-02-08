package com.bookstore.book.model.category;
import com.bookstore.book.model.book.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Integer id;

    @Column(name = "category_name")
    private String name;
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Book> books;
}
