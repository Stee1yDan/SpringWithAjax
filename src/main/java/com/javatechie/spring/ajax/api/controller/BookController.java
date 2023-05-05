package com.javatechie.spring.ajax.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javatechie.spring.ajax.api.dto.Book;
import com.javatechie.spring.ajax.api.dto.ServiceResponse;

@RestController
@RequestMapping
public class BookController
{

    List<Book> bookStore = new ArrayList<>();

    @PostMapping("/saveBook")
    public ResponseEntity<Object> addBook(@RequestBody Book book)
    {
        bookStore.add(book);
        ServiceResponse<Book> response = new ServiceResponse<Book>("success", book);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/getBooks")
    public ResponseEntity<Object> getAllBooks()
    {
        ServiceResponse<List<Book>> response = new ServiceResponse<>("success", bookStore);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
}
