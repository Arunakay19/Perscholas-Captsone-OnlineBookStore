package com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {


    @GetMapping("/index")
    private String index() {
        log.info("index");
        return "index";
    }
}
