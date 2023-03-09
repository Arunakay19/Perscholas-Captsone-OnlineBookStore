package com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.data;
import jakarta.transaction.Transactional;
import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository @Transactional(rollbackOn = Exception.class)
public interface UserRepoI extends JpaRepository<User, Integer>{
    Optional<User> findByEmailAllIgnoreCase(String email);
    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByEmailIgnoreCaseAndPassword(String email, String password);
}
