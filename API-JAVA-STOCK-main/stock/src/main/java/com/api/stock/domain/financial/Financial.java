package com.api.stock.domain.financial;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Table(name = "financial")
@Entity(name = "Financial")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Financial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private int value;

    @Enumerated(EnumType.STRING)
    private Stock stock;

    private Boolean active;

    public Financial(DataCreateFinancial dataCreateFinancial){
        this.description = dataCreateFinancial.description();
        this.value = dataCreateFinancial.value();
        this.stock = dataCreateFinancial.stock();
        this.active = true;
    }

    public void delete(){
        this.active = false;
    }
}
