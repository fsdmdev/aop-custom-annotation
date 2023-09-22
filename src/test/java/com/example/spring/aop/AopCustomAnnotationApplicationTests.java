package com.example.spring.aop;

import com.example.spring.aop.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AopCustomAnnotationApplicationTests {
    @Autowired
    private BookController bookController;

    @Test
    void contextLoads() {
        assertNotNull(bookController);
    }

}
