package com.example.controllers;

import com.example.dtos.NoteDto;
import com.example.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotesController {
    private final NoteService noteService;

    public NotesController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/note/{id}")
    public NoteDto getNoteById(@PathVariable("id") Long id) {
        return noteService.getNoteById(id);
    }

    @PostMapping("/note")
    public NoteDto createNote(@RequestBody NoteDto noteDto) {
        return noteService.createNote(noteDto);
    }
}
