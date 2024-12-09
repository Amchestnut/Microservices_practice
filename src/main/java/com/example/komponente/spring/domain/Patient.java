package com.example.komponente.spring.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@DiscriminatorValue("PATIENT")
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
public class Patient extends Person{
    private String medicalCode;

    @ManyToMany
    @JoinTable(
            name = "patient_has_doctor",
            joinColumns = @JoinColumn(name="patient_id"),
            inverseJoinColumns = @JoinColumn(name="doctor_id")
    )
    private List<Doctor> doctors;

}
