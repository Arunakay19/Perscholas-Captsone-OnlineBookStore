package com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.controller;

import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model.Book;
import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute Book b) {
        bookService.save(b);
        return "redirect:/admin";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book b) {
        bookService.save(b);
        return "redirect:/admin";

    }

    @RequestMapping("/editBook")
    public String editBook(@RequestParam int id, Model model) {
        System.out.println("bookEdit");
        Book b = bookService.getBookById(id);
        model.addAttribute("book", b);
        return "edit_book_form";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam int id, Model model) {
        bookService.deleteBook(id);
        return "redirect:/admin";
    }

    @RequestMapping("/add_order/{id}")
    public String showCart() {
        return "redirect:/cart";
    }
//    @RequestMapping("/mylist/{id}")
//    public String getMyList(@PathVariable("id") int id) {
//        Book b = bookService.getBookById(id);
//        MyBookList myBookList = new MyBookList(
//                b.getId(), b.getName(), b.getAuthor(), b.getPrice()
//        );
//        myBookListService.saveMyBooks(myBookList);
//        return "redirect:/my_books";
//    }


    @GetMapping("/new_book_form")
    private String new_book_form() {
        return "new_book_form";
    }

}
