package com.api.stock.domain.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "products")
@Entity(name = "Product")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    private String value;
    private Boolean active;

    public Product(DataCreateProduct dataCreateProduct){
        this.name = dataCreateProduct.name();
        this.code = dataCreateProduct.code();
        this.value = dataCreateProduct.value();
        this.active = true;
    }

    public void updateProducts(DataUpdateProduct dataUpdateProduct){
        if(dataUpdateProduct.name() != null){
            this.name = dataUpdateProduct.name();
        }
        if(dataUpdateProduct.code() != null){
            this.code = dataUpdateProduct.code();
        }
        if(dataUpdateProduct.value() != null){
            this.value = dataUpdateProduct.value();
        }
    }

    public void delete(){
        this.active = false;
    }
}
