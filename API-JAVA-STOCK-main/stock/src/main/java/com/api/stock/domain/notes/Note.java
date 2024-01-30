package com.api.stock.domain.notes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "notes")
@Entity(name = "Note")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private Boolean active;

    public Note(DataCreateNote dataCreateNote){
        this.title = dataCreateNote.title();
        this.description = dataCreateNote.description();
        this.active = true;
    }

    public void updateNote(DataUpdateNote dataUpdateNote){
        if(dataUpdateNote.title() != null){
            this.title = dataUpdateNote.title();
        }
        if(dataUpdateNote.description() != null){
            this.description = dataUpdateNote.description();
        }
    }

    public void delete(){
        this.active = false;
    }
}
