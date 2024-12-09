package com.example.komponente.spring.domain;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
// neki pregled servis, gde imamo pristup istorijama bolesti, pregledima, istorijom pregleda, i dodatna polja za lekove
public class Medication extends BaseEntity{
    private String name;
    private String dosage;
    private String instructions;

}
