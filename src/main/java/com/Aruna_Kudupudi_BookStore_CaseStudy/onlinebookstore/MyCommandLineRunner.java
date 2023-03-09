package com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore;

import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.data.CustomerRepoI;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyCommandLineRunner implements CommandLineRunner {

    @PostConstruct
    public void init(){
        log.debug("======== My Command Line Runner =========");
    }
    CustomerRepoI customerRepoI;
    @Autowired
    public MyCommandLineRunner (CustomerRepoI customerRepoI) {
        this.customerRepoI = customerRepoI;
    }

    @Override
    public void run(String... args) throws Exception {
        customerRepoI.saveAndFlush( new User("aruna","kudupudi","aruna@gmail.com", "password"));
        customerRepoI.saveAndFlush(new User("padmini","kodi","padmini@gmail.com", "password"));


    }
}
