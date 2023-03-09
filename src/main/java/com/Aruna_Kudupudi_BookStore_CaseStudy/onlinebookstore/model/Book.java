package com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    private double price;
    private String image_name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_author", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = { @JoinColumn(name = "author_id") })
    private List<Author> authors = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    public Book(String title, String image_name, double price) {
        this.title = title;
        this.image_name = image_name;
        this.price = price;
    }
    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        if (!authors.contains(author)) {
            authors.add(author);
            author.getBooks().add(this);
            log.info("add author executed: "+author.getName());
        }
    }
    public void removeAuthor(Author author) {
        if (authors.contains(author)) {
            authors.remove(author);
            author.getBooks().remove(this);
            log.info("remove author executed: "+author.getName());
        }
    }

}