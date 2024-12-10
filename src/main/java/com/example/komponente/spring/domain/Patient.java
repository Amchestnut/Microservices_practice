package com.example.komponente.spring.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@DiscriminatorValue("PATIENT")
public class Patient extends Person{
    private String medicalCode;

    @ManyToMany
    @JoinTable(
            name = "patient_has_doctor",
            joinColumns = @JoinColumn(name="patient_id"),
            inverseJoinColumns = @JoinColumn(name="doctor_id")
    )
    private List<Doctor> doctors;

    public Patient(String firstName, String lastName, String contactNumber, Address address, Status status, String medicalCode) {
        super(firstName, lastName, contactNumber, address, status);
        this.medicalCode = medicalCode;
    }

    public Patient() {
    }

    public Patient(String firstName, String lastName, String contactNumber, Address address, Status status, String medicalCode, List<Doctor> doctors) {
        super(firstName, lastName, contactNumber, address, status);
        this.medicalCode = medicalCode;
        this.doctors = doctors;
    }

    public Patient(String medicalCode, List<Doctor> doctors) {
        this.medicalCode = medicalCode;
        this.doctors = doctors;
    }

    public String getMedicalCode() {
        return medicalCode;
    }

    public void setMedicalCode(String medicalCode) {
        this.medicalCode = medicalCode;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
