package com.example.komponente.spring.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable     // ukljucujemo u osobu, NECU DA MI OVO BUDE ZASEBNA TABELA
// Jednu istu adresu moze koristiti vise Pacijenata npr, tako da moram da pazim sta stavljam kao entitet.

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;

}
