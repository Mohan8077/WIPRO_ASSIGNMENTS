package com.example.bookapi.controller;

import com.example.bookapi.model.Book;
import com.example.bookapi.model.BookList;
import com.example.bookapi.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    // ✅ XML response
    @GetMapping(value = "/bookXYZ", produces = "application/xml")
    public BookList getBooksAsXml() {
        List<Book> list = service.getAllBooks();
        BookList wrapper = new BookList();
        wrapper.setItems(list);
        return wrapper;
    }

    // ✅ JSON response
    @GetMapping("/books")
    public List<Book> getBooksAsJson() {
        return service.getAllBooks();
    }
}
