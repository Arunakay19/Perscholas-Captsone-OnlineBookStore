package com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.controller;

import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model.User;
import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/logout")
    public String logOut(){
        return "logout";
    }

    @PostMapping("/login_process")
    public String loginProcess(@RequestParam String emailId, @RequestParam String password,
                               HttpSession session, Model model){
        // validate emailId and password from database.
        User customer = userService.findByEmailAndPassword(emailId, password);
        if (customer != null) {
            // Store the username in the session
            session.setAttribute("emailId", emailId);
            model.addAttribute("logged", true);
            return "index"; // Redirect to the home page
        } else {
            model.addAttribute("error", true);
            return "login"; // Return the name of the login view with an error message
        }
    }
}
