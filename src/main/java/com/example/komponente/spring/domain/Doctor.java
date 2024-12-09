package com.example.komponente.spring.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
//@Table(name = "doctors")      NE MOZE OVO DA SE STAVI AKO IMAM SINGLE_TABLE !!! STRATEGIJA
@DiscriminatorValue("DOCTOR")   // ono po cemu se razlikuje, diskriminator za SINGLE_TABLE
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Doctor extends Person{
    private String specialization;

    // ok, ne moramo i ovde da pisemo RULES za join, napisali smo tamo u PATIENT.
    // medjutim, ovde moramo da imamo @ManyToMany vezu svakako, ali imamo i mappedBy
    ////// mappedBy je bas bitan, i to najvise je bitan, jer se vezuje za NAZIV LIST<> KOJU SAM KORISTIO TAMO U PATIENT, a to je bas "doctors" !!!!
    @ManyToMany(mappedBy = "doctors")
    private List<Patient> patients;     // ovu listu patients mapiraj sa listom doctors, u PATIENT


    public Doctor(String firstName, String lastName, String contactNumber, Address address, Status status, String specialization) {
        super(firstName, lastName, contactNumber, address, status);
        this.specialization = specialization;
    }

}
