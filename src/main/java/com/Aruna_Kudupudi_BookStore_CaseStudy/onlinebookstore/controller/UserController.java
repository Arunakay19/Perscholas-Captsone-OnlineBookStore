package com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.controller;

import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model.Book;
import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model.User;
import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.service.BookService;
import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
//@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/user_login")
    public String login(){
        return "login";
    }

    @GetMapping("/error_login")
    public String error_login(Model model){
        model.addAttribute("error", true);
        return "login";
    }

    @GetMapping("/admin")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public String admin_page(Model model,
                             Authentication authentication) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        List<GrantedAuthority> authorities = userDetails.getAuthorities().stream().collect(Collectors.toList());
        if ("ADMIN".equalsIgnoreCase(authorities.get(0).toString()) ||
                "ROLE_ADMIN".equalsIgnoreCase(authorities.get(0).toString())) {

            List<User> allUsers = userService.getAllUsers();
            List<Book> allBooks = bookService.getAllBooks();

            model.addAttribute("users", allUsers);
            model.addAttribute("books", allBooks);
            model.addAttribute("logged", true);
            return "admin_page";
        }
        return "admin_login";
    }

    @GetMapping("/user_form")
    public String user_form(Model model) {
        model.addAttribute("user", new User());
        return "user_form";
    }
    @GetMapping("/cart")
    public String cart() {
        return "cart";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam int id, Model model,
                             Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        if ("USER".equalsIgnoreCase( ((List)userDetails.getAuthorities()).get(0).toString()) ){
            userService.deleteUser(id);
        }
        return "redirect:/admin_page";
    }

    @PostMapping("/register_user")
    public String registerUser(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String password
    ) {

        userService.addUser(new User(
                firstName,
                lastName,
                email,
                passwordEncoder.encode(password),
                "USER"
        ));
        log.info("New user added to the store.");
        return "redirect:/user_login";
    }
}
