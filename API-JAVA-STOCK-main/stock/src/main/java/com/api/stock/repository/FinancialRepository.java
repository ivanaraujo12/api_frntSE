package com.api.stock.repository;

import com.api.stock.domain.financial.Financial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FinancialRepository extends JpaRepository<Financial, Long> {

    Page<Financial> findAllByActiveTrue(Pageable paginacao);
}
