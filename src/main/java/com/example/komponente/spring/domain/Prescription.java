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
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class Prescription extends BaseEntity{
    @ManyToOne
    private Doctor doctor;
    @ManyToOne  // da imamo @ManyToMany, onda bismo morali da imamo neku LISTU jel da, ne moze sa 1 entitetom, mora lista
    private Patient patient;
    @OneToOne
    private Medication medication;
    private Date prescriptionDate;

    public Prescription() {
    }

    public Prescription(Doctor doctor, Patient patient, Medication medication, Date prescriptionDate) {
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.prescriptionDate = prescriptionDate;
    }

    public Prescription(Long id, boolean deleted, boolean active, Doctor doctor, Patient patient, Medication medication, Date prescriptionDate) {
        super(id, deleted, active);
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.prescriptionDate = prescriptionDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public Date getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(Date prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }
}
