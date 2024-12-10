package com.example.komponente.spring.controller;

import com.example.komponente.spring.dto.PatientDTO;
import com.example.komponente.spring.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")   // prefiks za putanje
@AllArgsConstructor     // umesto AutoWired, ili umesto Setter / Getter
public class PatientController {

    // znaci FRONT i controller logika: Trazio si mi pacijenta, ja cu da ti gettujem pacijenta.

    private PatientService patientService;

    @GetMapping     // za GET
    public ResponseEntity<List<PatientDTO>> getAll(){
        return new ResponseEntity<>(patientService.findAll(), HttpStatus.OK);
    }



}

