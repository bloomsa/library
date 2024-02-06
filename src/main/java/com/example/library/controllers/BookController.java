package com.example.library.controllers;

import com.example.library.models.dto.BookDto;
import com.example.library.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable String id){
        try {
            return ResponseEntity.ok(bookService.getBook(id));
        } catch(EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "book not found", ex);
        }
    }

    @PostMapping()
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        return new ResponseEntity<>(bookService.saveBook(bookDto), HttpStatus.CREATED);
    }

}
