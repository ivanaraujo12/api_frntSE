package com.api.stock.controller;

import com.api.stock.domain.financial.DataCreateFinancial;
import com.api.stock.domain.financial.DataDetailsFinancial;
import com.api.stock.domain.financial.DataListFinancial;
import com.api.stock.domain.financial.Financial;
import com.api.stock.repository.FinancialRepository;
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
@RequestMapping("financeiro")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FinancialController {
    @Autowired
    private FinancialRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DataCreateFinancial dados, UriComponentsBuilder uriBuilder) {
        var financial = new Financial(dados);
        repository.save(financial);

        var uri = uriBuilder.path("/nota/{id}").buildAndExpand(financial.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailsFinancial(financial));
    }

    @GetMapping
    public ResponseEntity<Page<DataListFinancial>> listar(@PageableDefault(size = 10, sort = {"description"}) Pageable paginacao) {
        var page = repository.findAllByActiveTrue(paginacao).map(DataListFinancial::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var financial = repository.getReferenceById(id);
        financial.delete();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var financial = repository.getReferenceById(id);
        return ResponseEntity.ok(new DataDetailsFinancial(financial));
    }
}
