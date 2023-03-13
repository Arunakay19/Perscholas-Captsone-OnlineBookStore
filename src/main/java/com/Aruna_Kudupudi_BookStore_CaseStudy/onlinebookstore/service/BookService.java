package com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.service;

import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.data.BookRepoI;
import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model.Book;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
public class BookService {

    BookRepoI bookRepoI;

    @Autowired
    public BookService(BookRepoI bookRepoI) {
        this.bookRepoI = bookRepoI;
    }

    public Book getBookById(Integer id) {
        Optional<Book> optionalBook = bookRepoI.findById(id);
        return optionalBook.get();
    }

    public List<Book> getAllBooks() {
        return bookRepoI.findAll();
    }

    public void deleteBook(int id) {
        bookRepoI.deleteById(id);
    }

    public Book save(Book b) {
        return bookRepoI.save(b);
    }
}
