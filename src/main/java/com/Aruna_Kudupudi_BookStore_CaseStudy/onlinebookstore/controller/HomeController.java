package com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.controller;

import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model.Book;
import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.service.BookService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class HomeController {


    @Autowired
    BookService bookService;

    @GetMapping("/index")
    private String index() {
        log.info("index");
        return "index";
    }


    @GetMapping("/")
    public String home(Model model, HttpSession session){
        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("books", allBooks);

        String emailId = (String)session.getAttribute("emailId");
        if(emailId != null) {
            model.addAttribute("logged", true);
        }
        return "index";
    }

}
