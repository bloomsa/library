package com.example.libraryDemo.repository;

import com.example.libraryDemo.models.Author;
import org.springframework.data.repository.CrudRepository;


public interface AuthorRepository extends CrudRepository<Author, Long> {

}
