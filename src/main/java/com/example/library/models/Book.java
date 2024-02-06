package com.example.library.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Book {

    @Id
    String isbn;
    String title;
    List<String> genre;
    @ManyToOne
    @JoinColumn(name = "author_id")
    Author author;

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", author='" + author + '\'' +
                '}';
    }

    public Book() {
    }

    public Book(String isbn, String title, List<String> genre, Author author) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.author = author;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
