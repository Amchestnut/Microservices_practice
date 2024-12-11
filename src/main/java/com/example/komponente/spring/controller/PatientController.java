package com.example.komponente.spring.controller;

import com.example.komponente.spring.domain.Patient;
import com.example.komponente.spring.dto.PatientCreateDTO;
import com.example.komponente.spring.dto.PatientDTO;
import com.example.komponente.spring.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")   // prefiks za putanje
//@AllArgsConstructor     // umesto AutoWired, ili umesto Setter / Getter
public class PatientController {

    // znaci FRONT i controller logika: Trazio si mi pacijenta, ja cu da ti gettujem pacijenta.

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping     // za GET
    public ResponseEntity<List<PatientDTO>> getAll(){
        return new ResponseEntity<>(patientService.findAll(), HttpStatus.OK);
    }

    // PATH varijabla
    // ?medicalCode=12345  ---> request PARAM
    @GetMapping("/{medicalCode}")   // ne smem da imam 2 ista getmappinga, jelte, moram imati neku drugu putanju.  Ova putanja se lepi na ORIGINALNU, http://localhost:8080/patient + ovo
    public ResponseEntity<PatientDTO> getPatient(@PathVariable("medicalCode") String medicalCode){
        return new ResponseEntity<>(patientService.findByMedicalCode(medicalCode), HttpStatus.OK);
    }

    // A ZASTO JE DTO?
    // zato sto ne moze da ti prosledi ID pri kreiranju ;)))))
    @PostMapping
    public ResponseEntity<PatientDTO> getPatient(@RequestBody PatientCreateDTO patientCreateDTO){   // drugaciji DTO jer za njega treba i adresa npr, status
        return new ResponseEntity<>(patientService.add(patientCreateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{medicalCode}")
    public ResponseEntity<Boolean> removePatient(@PathVariable("medicalCode") String medicalCode){
        return new ResponseEntity<>(patientService.remove(medicalCode), HttpStatus.OK);
    }
}

