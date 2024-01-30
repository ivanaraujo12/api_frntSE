package com.api.stock.domain.notes;

public record DataDetailsNote(Long id, String title, String description, Boolean active) {
    public DataDetailsNote(Note note){
        this(note.getId(), note.getTitle(), note.getDescription(), note.getActive());
    }
}
