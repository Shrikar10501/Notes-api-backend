package com.example.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NoteDto {

    Long id;
    String title;
    String content;
    String createdAt;
    String updatedAt;

    // No-argument constructor for Spring/Jackson
    public NoteDto() {}

    public NoteDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.updatedAt = LocalDate.now().toString();
    }
    public NoteDto(Long id, String title, String content , String createdAt,String updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
