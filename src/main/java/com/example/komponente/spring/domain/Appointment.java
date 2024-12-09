package com.example.komponente.spring.domain;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Appointment", indexes = @Index(name="doctor_search", columnList = "doctor_id"))
// da ocu vise indeksa, mogu da napravi ARRAY indeksa: indexes =[ @Index(name="doctor_search", columnList = "doctor_id")), , , , ]

public class Appointment extends BaseEntity{

    // GLAVNO: ManyToOne: many instances of the current ENTITY: APPOINTMENT are associated with ONE PATIENT !!!!!!!!!!!!!!!
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;

    private Date dateAndTime;
    private String reason;

}
