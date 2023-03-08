package org.perscholas.onlinebookstore;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.onlinebookstore.data.CustomerRepoI;
import org.perscholas.onlinebookstore.model.Customer;
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
        customerRepoI.saveAndFlush( new Customer("aruna","kudupudi","aruna@gmail.com", "password"));
        customerRepoI.saveAndFlush(new Customer("padmini","kodi","padmini@gmail.com", "password"));


    }
}
