package com.javatechie.spring.ajax.api.controller;

import java.util.List;

import com.javatechie.spring.ajax.api.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javatechie.spring.ajax.api.model.Book;
import com.javatechie.spring.ajax.api.model.ServiceResponse;

@RestController
@RequestMapping
public class BookController
{

    private final BookRepository repository;

    public BookController(BookRepository repository)
    {
        this.repository = repository;
    }

    @PostMapping("/saveBook")
    public ResponseEntity<Object> addBook(@RequestBody Book book)
    {
        repository.save(book);
        ServiceResponse<Book> response = new ServiceResponse<Book>("success", book);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @PostMapping("/deleteBook/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable int id)
    {
        repository.deleteById(id);
        ServiceResponse<Book> response = new ServiceResponse<Book>("success", null);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @PostMapping("/editBook")
    public ResponseEntity<Object> editBook(@RequestBody Book book)
    {
        System.out.println(1);
        repository.deleteById(book.getId() + 1);
        repository.save(book);
        ServiceResponse<Book> response = new ServiceResponse<Book>("success", book);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/getBooks")
    public ResponseEntity<Object> getAllBooks()
    {
        ServiceResponse<List<Book>> response = new ServiceResponse<>("success", repository.findAll());
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
}
