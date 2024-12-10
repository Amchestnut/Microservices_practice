package com.example.komponente.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class PatientDTO {

    private String firstName;
    private String lastName;
    private String medicalCode;

    public PatientDTO() {
    }

    public PatientDTO(String firstName, String lastName, String medicalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.medicalCode = medicalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMedicalCode() {
        return medicalCode;
    }

    public void setMedicalCode(String medicalCode) {
        this.medicalCode = medicalCode;
    }
}
