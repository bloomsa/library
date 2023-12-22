package com.example.libraryDemo.models.dto;

import java.util.List;

public record BookDto(String isbn, String title, List<String> genre, String author) {

}
