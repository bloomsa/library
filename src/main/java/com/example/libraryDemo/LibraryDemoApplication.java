package com.example.libraryDemo;

import com.example.libraryDemo.models.dto.AuthorDto;
import com.example.libraryDemo.models.dto.BookDto;
import com.example.libraryDemo.service.AuthorService;
import com.example.libraryDemo.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class LibraryDemoApplication {

    private static final Logger log = LoggerFactory.getLogger(LibraryDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LibraryDemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner runner(AuthorService authorService, BookService bookService){
        return (args -> {
            // "running" the app, before the endpoints are built
            authorService.saveAuthor(new AuthorDto("George", "Orwell", LocalDate.of(1903, 6, 25)));
            bookService.saveBook(new BookDto("9780140817744", "1984", List.of("Science Fiction", "Dystopian Fiction", "Political Fiction"), "George Orwell"));
            authorService.findAll().forEach(author -> log.info(author.toString()));
            bookService.findAll().forEach(book -> log.info(book.toString()));
        });
    }
}
