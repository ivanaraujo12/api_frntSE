package com.api.stock.repository;

import com.api.stock.domain.notes.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Page<Note> findAllByActiveTrue(Pageable pageable);
}
