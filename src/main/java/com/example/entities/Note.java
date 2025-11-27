package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Note {

    @Column
    String id;

    @Column
    String title;

    @Column
    String content;

    @Column
    String createdAt;

    @Column
    String updatedAt;
}
