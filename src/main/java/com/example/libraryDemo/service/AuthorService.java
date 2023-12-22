package com.example.libraryDemo.service;

import com.example.libraryDemo.models.Author;
import com.example.libraryDemo.models.dto.AuthorDto;
import com.example.libraryDemo.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorDto saveAuthor(AuthorDto authorDto) {
        Author author = new Author(authorDto.firstName(), authorDto.lastName(), authorDto.birthday());
        Author resp = authorRepository.save(author);
        return new AuthorDto(resp.getFirstName(), resp.getLastName(), resp.getBirthday());
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

}
