package com.api.stock.domain.notes;

import com.api.stock.domain.contact.DataListContact;


public record DataListNote(Long id, String title, String description, Boolean active) {
    public DataListNote(Note note){
        this(note.getId(), note.getTitle(), note.getDescription(), note.getActive());
    }
}
