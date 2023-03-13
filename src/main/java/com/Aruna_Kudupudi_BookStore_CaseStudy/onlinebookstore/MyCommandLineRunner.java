package com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore;

import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.data.BookRepoI;
import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.data.UserRepoI;
import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model.Book;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyCommandLineRunner implements CommandLineRunner {

    @PostConstruct
    public void init(){
        log.debug("======== My Command Line Runner =========");
    }
    UserRepoI customerRepoI;
    BookRepoI bookRepoI;

    PasswordEncoder passwordEncoder;
    @Autowired
    public MyCommandLineRunner (UserRepoI customerRepoI, BookRepoI bookRepoI, PasswordEncoder passwordEncoder) {
        this.customerRepoI = customerRepoI;
        this.bookRepoI = bookRepoI;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        customerRepoI.saveAndFlush(
                new User("aruna",
                        "kudupudi",
                        "aruna@gmail.com",
                        passwordEncoder.encode("pass"),
                        "ADMIN"));

        customerRepoI.saveAndFlush(new User("padmini","kodi","padmini@gmail.com",
                passwordEncoder.encode("pass"),
                "USER" ));

        Book clean_code = new Book("Clean Code: A Handbook of Agile Software Craftsmanship",
                "clean_code.jpeg", 10.50,
                "Robert C. Martin");
        bookRepoI.save(clean_code);
//        imageService.save(file, fromDB.getEmail());

        Book intro_algo = new Book("Introduction to Algorithms", "intro_algo.jpg", 15.50,
                "Thomas H. Cormen, Charles E. Leiserson");
//        "Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein"
        bookRepoI.saveAndFlush(intro_algo);

        // Book 3
        Book scip = new Book("Structure and Interpretation of Computer Programs (SICP)", "scip.jpg", 12.50,
                "Harold Abelson, Gerald Jay Sussman, Julie Sussman");
        bookRepoI.saveAndFlush(scip);


        // Book 4

        Book code_complete = new Book("Code Complete: A Practical Handbook of Software Construction", "code_complete.jpeg",
                20.00, "Steve McConnell");
        bookRepoI.saveAndFlush(code_complete);


        // Book 5
        // Design Patterns: Elements of Reusable Object-Oriented Software
        // Author – Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides, Grady
        Book design_patterns = new Book("Design Patterns: Elements of Reusable Object-Oriented Software)", "design_pattern.jpeg",
                25.00, "Erich Gamma, Richard Helm");
        bookRepoI.saveAndFlush(design_patterns);

    }
}
