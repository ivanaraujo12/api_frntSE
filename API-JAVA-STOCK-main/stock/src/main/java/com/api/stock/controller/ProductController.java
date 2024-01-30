package com.api.stock.controller;

import com.api.stock.domain.product.*;
import com.api.stock.repository.ProductRepository;
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
@RequestMapping("produto")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DataCreateProduct dados, UriComponentsBuilder uriBuilder) {
        var product = new Product(dados);
        repository.save(product);

        var uri = uriBuilder.path("/produto/{id}").buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailsProduct(product));
    }

    @GetMapping
    public ResponseEntity<Page<DataListProduct>> listar(@PageableDefault(size = 10, sort = {"name"}) Pageable paginacao) {
        var page = repository.findAllByActiveTrue(paginacao).map(DataListProduct::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DataUpdateProduct dados) {
        var product = repository.getReferenceById(dados.id());
        product.updateProducts(dados);

        return ResponseEntity.ok(new DataDetailsProduct(product));
    }

    @DeleteMapping("/{id}")
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var product = repository.getReferenceById(id);
        product.delete();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var product = repository.getReferenceById(id);
        return ResponseEntity.ok(new DataDetailsProduct(product));
    }
}
