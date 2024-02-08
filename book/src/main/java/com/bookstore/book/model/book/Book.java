package com.bookstore.book.model.book;

import com.bookstore.book.model.category.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name="autor")
    private  String autor;
    @Column(name = "created_at")
    private Date año;
    @ManyToOne
    @JoinColumn(name = "fk_category")
    private Category category;
}
