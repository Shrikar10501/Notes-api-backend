package com.example.service;

import com.example.dtos.NoteDto;
import com.example.entities.Note;
import com.example.repositories.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    // Convert Note to NoteDto
    private NoteDto toDto(Note note) {
        return new NoteDto(
                note.getId(),
                note.getTitle(),
                note.getContent()
        );
    }

    private NoteDto toDtoCreated(Note note) {
        return new NoteDto(
                note.getId(),
                note.getTitle(),
                note.getContent(),
                note.getCreatedAt(),
                note.getUpdatedAt()
        );
    }

    // Convert NoteDto to Note
    private Note toEntity(NoteDto dto) {
        Note note = new Note();
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        note.setCreatedAt(LocalDate.now().toString());
        note.setUpdatedAt(LocalDate.now().toString());
        return note;
    }

    public List<NoteDto> getAllNotes() {
        return noteRepository.findAll().stream().map(this::toDto).toList();
    }

    public NoteDto getNoteById(Long id) {
        Optional<Note> note = noteRepository.findById(id);
        return note.map(this::toDto).orElse(null);
    }

    public NoteDto createNote(NoteDto noteDto) {
        Note note = toEntity(noteDto);
        Note saved = noteRepository.save(note);
        return toDtoCreated(saved);
    }

    public NoteDto updateNote(Long id, NoteDto noteDto) {
        Optional<Note> existing = noteRepository.findById(id);
        if (existing.isPresent()) {
            Note note = existing.get();
            note.setTitle(noteDto.getTitle());
            note.setContent(noteDto.getContent());
            note.setUpdatedAt(LocalDate.now().toString());
            Note saved = noteRepository.save(note);
            return toDto(saved);
        }
        return null;
    }

    public boolean deleteNote(Long id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
