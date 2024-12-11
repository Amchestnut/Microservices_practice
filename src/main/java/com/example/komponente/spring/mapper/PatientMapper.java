package com.example.komponente.spring.mapper;

// DOMENSKI U DTO
// DTO U DOMENSKI

import com.example.komponente.spring.domain.Patient;
import com.example.komponente.spring.dto.PatientCreateDTO;
import com.example.komponente.spring.dto.PatientDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
//@AllArgsConstructor
public class PatientMapper {

    public PatientDTO getDtoFromDomain(Patient patient){
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setFirstName(patient.getFirstName());
        patientDTO.setLastName(patient.getLastName());
        patientDTO.setMedicalCode(patient.getMedicalCode());

        return patientDTO;
    }

    public PatientMapper() {
    }

    public Patient getDomainFromDTO(PatientCreateDTO patientCreateDTO){
        /// treba da imam gettere i settere, jer ako ja u pacijentu ocu da ubacim doktora.
        /// Ja bi prvo trebao tog doktora da nadjem preko repozitorija, pa ga onda dal je null ili nije, itd, pa da ga metnem

        Patient patient = new Patient(patientCreateDTO.getFirstName(), patientCreateDTO.getLastName(), patientCreateDTO.getContactNumber(), patientCreateDTO.getAddress(), patientCreateDTO.getStatus(), patientCreateDTO.getMedicalCode());
        return patient;
    }

}
