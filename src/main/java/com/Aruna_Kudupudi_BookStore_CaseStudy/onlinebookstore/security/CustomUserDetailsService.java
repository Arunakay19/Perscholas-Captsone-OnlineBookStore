package com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.security;

import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.data.UserRepoI;
import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;


public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepoI userRepoI;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Optional<User> user = userRepoI.findByEmailAllIgnoreCase(username);

        return user.map(CustomUserDetails::new)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found: " + username));
    }
}
