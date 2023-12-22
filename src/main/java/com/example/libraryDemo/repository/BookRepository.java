package com.example.libraryDemo.repository;

import com.example.libraryDemo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
