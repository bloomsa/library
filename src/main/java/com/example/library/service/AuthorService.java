package com.example.library.service;

import com.example.library.models.Author;
import com.example.library.models.dto.AuthorDto;
import com.example.library.repository.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public AuthorDto getAuthor(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Author not found"));
        return toDto(author);
    }

    private AuthorDto toDto(Author author) {
        return new AuthorDto(author.getFirstName(), author.getLastName(), author.getBirthday());
    }
}
