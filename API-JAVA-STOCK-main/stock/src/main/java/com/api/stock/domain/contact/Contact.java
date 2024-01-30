package com.api.stock.domain.contact;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "contacts")
@Entity(name = "Contact")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String number;

    private Boolean active;

    public Contact(DataCreateContact dataCreateContact){
        this.name = dataCreateContact.name();
        this.email = dataCreateContact.email();
        this.number = dataCreateContact.number();
        this.active = true;
    }

    public void updateContact(DataUpdateContact dataUpdateContact){
        if(dataUpdateContact.name() != null){
            this.name = dataUpdateContact.name();
        }
        if(dataUpdateContact.email() != null){
            this.email = dataUpdateContact.email();
        }
        if(dataUpdateContact.number() != null){
            this.number = dataUpdateContact.number();
        }
    }

    public void delete(){
        this.active = false;
    }

}
