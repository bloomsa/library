package com.example.library.controllers;

import com.example.library.models.dto.AuthorDto;
import com.example.library.service.AuthorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(authorService.getAuthorDto(id));
        } catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "author not found", ex);
        }
    }

    @PostMapping()
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
        return new ResponseEntity<>(authorService.saveAuthor(authorDto), HttpStatus.CREATED);
    }
}
