package com.example.spring.aop.controller;

import org.springframework.web.bind.annotation.*;

/**
 * This controller defines two endpoints: one for retrieving a book by ID and another for creating a new book.
 * @author felipeMello
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping("/{id}")
    public String getBookById(@PathVariable Long id) {
        return "Fetching book with ID: " + id;
    }

    @PostMapping
    public String createBook(@RequestBody String book) {
        return "Creating a new book: " + book;
    }
}