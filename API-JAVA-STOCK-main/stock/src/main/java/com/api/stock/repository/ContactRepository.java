package com.api.stock.repository;

import com.api.stock.domain.contact.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Page<Contact> findAllByActiveTrue(Pageable pageable);
}
