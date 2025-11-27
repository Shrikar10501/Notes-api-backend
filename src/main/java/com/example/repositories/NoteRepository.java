package com.example.repositories;

import com.example.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class NoteRepository extends JpaRepository<Note, Long> {
}
