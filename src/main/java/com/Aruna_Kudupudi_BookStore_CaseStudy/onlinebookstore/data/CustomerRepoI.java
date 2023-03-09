package com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.data;
import jakarta.transaction.Transactional;
import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository @Transactional(rollbackOn = Exception.class)
public interface CustomerRepoI extends JpaRepository<Customer, Integer>{
    Optional<Customer> findByEmailAllIgnoreCase(String email);
    Optional<Customer> findByEmailAndPassword(String email, String password);

}
