package com.api.stock.controller;

import com.api.stock.domain.notes.*;
import com.api.stock.repository.NoteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("nota")
@CrossOrigin(origins = "*", maxAge = 3600)
public class NoteController {
    @Autowired
    private NoteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DataCreateNote dados, UriComponentsBuilder uriBuilder) {
        var note = new Note(dados);
        repository.save(note);

        var uri = uriBuilder.path("/nota/{id}").buildAndExpand(note.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailsNote(note));
    }

    @GetMapping
    public ResponseEntity<Page<DataListNote>> listar(@PageableDefault(size = 10, sort = {"title"}) Pageable paginacao) {
        var page = repository.findAllByActiveTrue(paginacao).map(DataListNote::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DataUpdateNote dados) {
        var note = repository.getReferenceById(dados.id());
        note.updateNote(dados);

        return ResponseEntity.ok(new DataDetailsNote(note));
    }

    @DeleteMapping("/{id}")
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var note = repository.getReferenceById(id);
        note.delete();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var note = repository.getReferenceById(id);
        return ResponseEntity.ok(new DataDetailsNote(note));
    }
}
