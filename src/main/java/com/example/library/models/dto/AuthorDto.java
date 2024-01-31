package com.example.library.models.dto;

import java.time.LocalDate;

public record AuthorDto(String firstName, String lastName, LocalDate birthday) {

}
