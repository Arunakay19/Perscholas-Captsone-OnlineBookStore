package com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.data;

import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthGroupRepoI extends JpaRepository<AuthGroup, Integer>{
    List<AuthGroup> findByEmail(String username);

}
