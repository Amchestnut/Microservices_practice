package com.example.komponente.spring.dto;

import com.example.komponente.spring.domain.Address;
import com.example.komponente.spring.domain.Status;

public class PatientCreateDTO {
    private String firstName;
    private String lastName;
    private String medicalCode;
    private Address address;        /// adresa je EMBEDDABLE, znaci nema ID, znaci mozemo ovako da je ubacimo
    private Status status;
    private String contactNumber;

    public PatientCreateDTO() {
    }

    public PatientCreateDTO(String firstName, String lastName, String medicalCode, Address address, String contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.medicalCode = medicalCode;
        this.address = address;
        this.contactNumber = contactNumber;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
