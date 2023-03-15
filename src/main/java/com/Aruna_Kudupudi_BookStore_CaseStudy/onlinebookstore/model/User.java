package com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    String firstName;
    String lastName;

    String password;
    private String email;
    private String roles;
    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    public User(String firstName, String lastName, String email, String password, String roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

}
