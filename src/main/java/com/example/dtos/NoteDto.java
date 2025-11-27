package com.example.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class NoteDto {

    String id;
    String title;
    String content;
    String createdAt;
    String updatedAt;

    public NoteDto(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.updatedAt = LocalDate.now().toString();
    }

    public NoteDto(String id, String title, String content , String createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = LocalDate.now().toString();
        this.updatedAt = LocalDate.now().toString();
    }
}
