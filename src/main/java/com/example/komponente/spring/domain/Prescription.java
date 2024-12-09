package com.example.komponente.spring.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prescription extends BaseEntity{
    @ManyToOne
    private Doctor doctor;
    @ManyToOne  // da imamo @ManyToMany, onda bismo morali da imamo neku LISTU jel da, ne moze sa 1 entitetom, mora lista
    private Patient patient;
    @OneToOne
    private Medication medication;
    private Date prescriptionDate;
}
