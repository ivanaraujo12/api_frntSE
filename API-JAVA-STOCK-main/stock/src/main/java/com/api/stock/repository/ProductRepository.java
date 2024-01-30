package com.api.stock.repository;

import com.api.stock.domain.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; // Correção na importação
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByActiveTrue(Pageable pageable);
}