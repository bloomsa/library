package com.example.libraryDemo.models.dto;

import java.time.LocalDate;

public record AuthorDto(String firstName, String lastName, LocalDate birthday) {

}
