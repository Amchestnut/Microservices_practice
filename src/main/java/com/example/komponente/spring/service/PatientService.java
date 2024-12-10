package com.example.komponente.spring.service;

import com.example.komponente.spring.dto.PatientDTO;

import java.util.List;

public interface PatientService {

    // Iz BAZE ce da dohvata domenske, ali ce da vraca DTO   (preradice ih)
    List<PatientDTO> findAll();
}
