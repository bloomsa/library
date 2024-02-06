package com.example.library.service;

import com.example.library.models.Author;
import com.example.library.models.Book;
import com.example.library.models.dto.BookDto;
import com.example.library.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final AuthorService authorService;
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public BookDto saveBook(BookDto bookDto) {
        Author author = authorService.getAuthorById(bookDto.author_id());
        Book book = new Book(bookDto.isbn(), bookDto.title(), bookDto.genre(), author);
        Book resp = bookRepository.save(book);
        return new BookDto(resp.getIsbn(), resp.getTitle(), resp.getGenre(), author.getId());
    }

    public BookDto getBook(String id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found"));
        return toDto(book);
    }
    public List<Book> findAll() {return bookRepository.findAll();}

    private BookDto toDto(Book book) {
        return new BookDto(book.getIsbn(), book.getTitle(), book.getGenre(), book.getAuthor().getId());
    }
}
