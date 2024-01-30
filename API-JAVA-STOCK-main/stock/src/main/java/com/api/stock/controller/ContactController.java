package com.api.stock.controller;

import com.api.stock.domain.contact.*;
import com.api.stock.repository.ContactRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("contato")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ContactController {
    @Autowired
    private ContactRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DataCreateContact dados, UriComponentsBuilder uriBuilder) {
        var contact = new Contact(dados);
        repository.save(contact);

        var uri = uriBuilder.path("/produto/{id}").buildAndExpand(contact.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailsContact(contact));
    }

    @GetMapping
    public ResponseEntity<Page<DataListContact>> listar(@PageableDefault(size = 10, sort = {"name"}) Pageable paginacao) {
        var page = repository.findAllByActiveTrue(paginacao).map(DataListContact::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DataUpdateContact dados) {
        var contact = repository.getReferenceById(dados.id());
        contact.updateContact(dados);

        return ResponseEntity.ok(new DataDetailsContact(contact));
    }

    @DeleteMapping("/{id}")
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var contact = repository.getReferenceById(id);
        contact.delete();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var contact = repository.getReferenceById(id);
        return ResponseEntity.ok(new DataDetailsContact(contact));
    }
}
