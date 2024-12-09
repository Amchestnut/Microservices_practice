package com.example.komponente.spring.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("NURSE")
public class Nurse extends Person{
    private String licence;

}
