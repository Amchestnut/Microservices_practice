package com.example.komponente.spring.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// od ove klase NECU NAPRAVITI TABELU, ali svuda gde je posle iskoristim, gde je NASLEDJUJU, imace u njoj definisana polja.
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BaseEntity {
    // ovo je nesto sto svaka TABELA IMA, koja je bude nasledila !!!
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)     // auto - sam izaberi strategiju
    private Long id;
    private boolean deleted;
    private boolean active;  // da li je aktiviran user, ono sa EMAIl
    // imaj i nesto da pamti - kad je kreiran !!

}
