package com.example.komponente.spring.service.implementation;

import com.example.komponente.spring.domain.Patient;
import com.example.komponente.spring.dto.PatientCreateDTO;
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
//@AllArgsConstructor     /// posto o patient repository BRINE SPRING, mi moramo ovom ovde da damo all args construktor
public class PatientServiceImplementation implements PatientService {
    // kako ce servis da dobije listu pacijenata? pa repository
    private PatientRepository patientRepository;
    private PatientMapper patientMapper;

    public PatientServiceImplementation(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

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

    @Override
    public PatientDTO findByMedicalCode(String medicalCode){
        Patient patient = patientRepository.findByMedicalCode(medicalCode).orElseThrow(() -> new RuntimeException("patient not found"));    // ovo "orElse" dodajemo jer smo tamo imali OPTIONAL<> , pa moze da se vrati NULL

        return patientMapper.getDtoFromDomain(patient);  // vratim pacijenta kog sam nasao
    }

    @Override
    public PatientDTO add(PatientCreateDTO patientCreateDTO) {
        Patient p = patientMapper.getDomainFromDTO(patientCreateDTO);

        // AKO NAM TREBA ID OD PACIJENTA NAKON UVANJA, KAZEM P = ...........
        // bas bas bas bitno
        p = patientRepository.save(p);        // ovo ce da mi sacuva pacijenta !!! ,, zbog ovog p, mocicemo da koristimo pacijenta sa ID
        return patientMapper.getDtoFromDomain(p);
    }

    @Override
    public Boolean remove(String medicalCode) {
        Patient patient = patientRepository.findByMedicalCode(medicalCode).orElseThrow(() -> new RuntimeException("patient not found"));    // ovo "orElse" dodajemo jer smo tamo imali OPTIONAL<> , pa moze da se vrati NULL

        patientRepository.delete(patient);  // retko se poziva ovo, jer mi uvek radimo SOFT DELETE !!!
        return true;
    }


}
