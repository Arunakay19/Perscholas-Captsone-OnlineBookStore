package com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore;

import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void testCreateUser() {
        User user = new User(1, "Srinivas", "Kodi","admin@gmail.com",
                "password", "ADMIN");

        assertEquals(1, user.getId());
        assertEquals("admin@gmail.com", user.getEmail());
        assertEquals("password", user.getPassword());
    }
}
