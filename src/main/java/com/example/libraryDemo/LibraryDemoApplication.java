package com.example.libraryDemo;

import com.example.libraryDemo.models.dto.AuthorDto;
import com.example.libraryDemo.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryDemoApplication {

    private static final Logger log = LoggerFactory.getLogger(LibraryDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LibraryDemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner runner(AuthorService authorService){
        return (args -> {
            authorService.saveAuthor(new AuthorDto("Hank", "Green"));

            authorService.findAll().forEach(author -> log.info(author.toString()));
        });
    }
}
