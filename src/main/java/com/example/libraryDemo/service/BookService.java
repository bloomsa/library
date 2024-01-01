package com.example.libraryDemo.service;

import com.example.libraryDemo.models.Book;
import com.example.libraryDemo.models.dto.BookDto;
import com.example.libraryDemo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDto saveBook(BookDto bookDto) {
        Book book = new Book(bookDto.isbn(), bookDto.title(), bookDto.genre(), bookDto.author());
        Book resp = bookRepository.save(book);
        return new BookDto(resp.getIsbn(), resp.getTitle(), resp.getGenre(), resp.getAuthor());
    }

    public List<Book> findAll() {return bookRepository.findAll();}
}
