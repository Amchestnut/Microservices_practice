package com.example.komponente.spring.mapper;

// DOMENSKI U DTO
// DTO U DOMENSKI

import com.example.komponente.spring.domain.Patient;
import com.example.komponente.spring.dto.PatientDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PatientMapper {

    public PatientDTO getDtoFromDomain(Patient patient){
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setFirstName(patient.getFirstName());
        patientDTO.setLastName(patient.getLastName());
        patientDTO.setMedicalCode(patient.getMedicalCode());

        return patientDTO;
    }
}
