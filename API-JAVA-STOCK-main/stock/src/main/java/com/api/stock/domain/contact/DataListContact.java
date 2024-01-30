package com.api.stock.domain.contact;

public record DataListContact(Long id, String name, String email, String number) {
    public DataListContact(Contact contact){
        this(contact.getId(), contact.getName(), contact.getEmail(), contact.getNumber());
    }
}
