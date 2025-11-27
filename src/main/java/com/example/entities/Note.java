package com.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "notes")
@Getter
@Setter
public class Note {

    @Column
    @Id
    @GeneratedValue
    private String id;

    @Column
    @NotBlank
    private String title;

    @Column
    private String content;

    @Column
    @NotBlank
    private String createdAt;

    @Column
    private String updatedAt;
}
