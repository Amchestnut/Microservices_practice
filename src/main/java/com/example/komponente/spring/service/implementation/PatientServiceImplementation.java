package com.example.komponente.spring.service.implementation;

import com.example.komponente.spring.domain.Patient;
import com.example.komponente.spring.dto.PatientDTO;
import com.example.komponente.spring.mapper.PatientMapper;
import com.example.komponente.spring.repository.PatientRepository;
import com.example.komponente.spring.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service    // spring ce da se brine o njemu
@AllArgsConstructor     /// posto o patient repository BRINE SPRING, mi moramo ovom ovde da damo all args construktor
public class PatientServiceImplementation implements PatientService {
    // kako ce servis da dobije listu pacijenata? pa repository
    private PatientRepository patientRepository;
    private PatientMapper patientMapper;

    @Override
    public List<PatientDTO> findAll() {
//        List<Patient> patients = patientRepository.findAll();   // a ovde dobijem sve pacijente
//        List<PatientDTO> response = new ArrayList<>();      // odgovor je lista, ali onih DTO
//        for(Patient p : patients){
//            response.add(new PatientDTO(p.getFirstName(), p.getLastName(), p.getMedicalCode()));
//        }
//
//        return response;

        return patientRepository.findAll()
                .stream()   // svaki objekat dobijemo, i mapiramo ga u dto
                .map(patient -> patientMapper.getDtoFromDomain(patient))
                .collect(Collectors.toList());
    }

}
