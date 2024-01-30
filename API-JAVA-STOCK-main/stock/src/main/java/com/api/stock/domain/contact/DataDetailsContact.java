package com.api.stock.domain.contact;

public record DataDetailsContact(Long id, String name, String email, String number, Boolean active) {
    public DataDetailsContact(Contact contact){
        this(contact.getId(), contact.getName(), contact.getEmail(), contact.getNumber(), contact.getActive());
    }
}
