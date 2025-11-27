package com.example.dtos;

import lombok.Data;

@Data
public class NoteDto {

    String id;
    String title;
    String content;
    String createdAt;
    String updatedAt;
}
