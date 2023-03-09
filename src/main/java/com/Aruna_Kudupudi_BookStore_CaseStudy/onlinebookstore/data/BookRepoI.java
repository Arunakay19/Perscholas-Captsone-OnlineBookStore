package com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.data;

import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional(rollbackOn = Exception.class)
public interface BookRepoI extends JpaRepository<Book, Integer> {
//    Optional<Book> findByTitleAllIgnoreCase(String title);
}
