package com.example.komponente.spring.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity     // When I run the program, in Database I will have a TABLE called person !!!
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
// da nisam dodao ovaj naziv tabele @Table, naziv tabele bi bio samo "person" malim slovima. Dobro zbog raznih OS (mac, windows)
@Table(name = "person_table")     // Ovde zadajem kako ce da se ZOVE OVA TABELA, ako je budem pravio

// Ova klasa ce da se nasledjuje. Opet imamo nekoliko strategija kako cemo to da uradimo.
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)

public abstract class Person extends BaseEntity {
    private String firstName;
    private String lastName;
    private String contactNumber;

    @Embedded   // Ukljucujemo ovu adresu iz ADDRESS. Tamo imamo @Embeddable a ovde @Embedded
    private Address address;
//    @Enumerated   PO DEFAULTU, KORISTI ORDINAL, ja necu ordinal brojeve, nego vrednost koja je namapirana na taj broj
    @Enumerated(value = EnumType.STRING)
    private Status status;

//    public Person(String firstName, String lastName, String contactNumber, Address address, Status status) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.contactNumber = contactNumber;
//        this.address = address;
//        this.status = status;
//    }


    public Person() {
    }

    public Person(String firstName, String lastName, String contactNumber, Address address, Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.address = address;
        this.status = status;
    }

    public Person(Long id, boolean deleted, boolean active, String firstName, String lastName, String contactNumber, Address address, Status status) {
        super(id, deleted, active);
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.address = address;
        this.status = status;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
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
}
