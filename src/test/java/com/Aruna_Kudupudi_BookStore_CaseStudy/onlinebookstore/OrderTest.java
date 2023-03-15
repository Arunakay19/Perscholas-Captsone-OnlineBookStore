package com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore;


import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model.Book;
import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model.Order;
import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model.OrderItem;
import com.Aruna_Kudupudi_BookStore_CaseStudy.onlinebookstore.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class OrderTest {

    private User user;
    private Book book;
    private List<OrderItem> orderItems;

    @BeforeEach
    void setUp() {
        user = new User(1, "Srinivas", "Kodi","admin@gmail.com",
                "password", "ADMIN");
        book = new Book("Test Book", 10.00, "Test Author");

        orderItems = new ArrayList<>();
        Order order = new Order();
        order.setUser(user);
//        order.setOrderItems();
//        orderItems.add();
    }

    @Test
    void testCreateOrder() {
        Order order = new Order();
        order.setId(1);
        order.setUser(user);
//        order.setOrderItems(Arrays.asList(book));
        assertEquals(user, order.getUser());
        assertEquals(orderItems, order.getOrderItems());
    }
}
