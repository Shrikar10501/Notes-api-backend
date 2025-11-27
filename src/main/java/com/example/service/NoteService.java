package com.example.service;

import com.example.dtos.NoteDto;
import com.example.entities.Note;
import com.example.repositories.NoteRepository;
import org.springframework.stereotype.Service;

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
                note.getCreatedAt()
        );
    }

    // Convert NoteDto to Note
    private Note toEntity(NoteDto dto) {
        Note note = new Note();
        note.setId(dto.getId());
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        note.setCreatedAt(dto.getCreatedAt());
        note.setUpdatedAt(dto.getUpdatedAt());
        return note;
    }

    public List<NoteDto> getAllNotes() {
        return noteRepository.findAll().stream().map(this::toDto).toList();
    }

    public NoteDto getNoteById(String id) {
        Optional<Note> note = noteRepository.findById(id);
        return note.map(this::toDto).orElse(null);
    }

    public NoteDto createNote(NoteDto noteDto) {
        Note note = toEntity(noteDto);
        Note saved = noteRepository.save(note);
        return toDtoCreated(saved);
    }

    public NoteDto updateNote(String id, NoteDto noteDto) {
        Optional<Note> existing = noteRepository.findById(id);
        if (existing.isPresent()) {
            Note note = existing.get();
            note.setTitle(noteDto.getTitle());
            note.setContent(noteDto.getContent());
            note.setUpdatedAt(noteDto.getUpdatedAt());
            Note saved = noteRepository.save(note);
            return toDto(saved);
        }
        return null;
    }

    public boolean deleteNote(String id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
