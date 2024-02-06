package com.example.library.models.dto;

import java.util.List;

public record BookDto(String isbn, String title, List<String> genre, Long author_id) {

}
