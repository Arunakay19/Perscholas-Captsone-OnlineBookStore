package com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.controller;

import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model.Book;
import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.service.BookService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
@Slf4j
public class HomeController {


    @Autowired
    BookService bookService;

    @GetMapping("/")
    private String index(Model model, Principal principal) {
        log.info("Welcome Page");
        String emailId= principal.getName();
        if(emailId != null) {
            model.addAttribute("logged", true);
        }
        return "index";
    }


    @GetMapping("/available_books")
    public String home(Model model){
        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("books", allBooks);
        model.addAttribute("logged", true);
        return "available_books";
    }

}
