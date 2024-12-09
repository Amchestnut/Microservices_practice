package com.example.komponente.spring.repository;

import com.example.komponente.spring.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Ocekujem da ovo bude repozitorijum sa rad sa <DOKTOROM> , gde je njegov ID: <LONG> !!! <DOCTOR, LONG>
// @Repository -> striktno vezana za slov cuvanja i komunikacije sa bazom, i sve sto je selektovano sa REPOSITORY, u pozadini je: COMPONENT
// znaci, COMPONENT. Ona se koristi za siru upotrebu

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {


}
