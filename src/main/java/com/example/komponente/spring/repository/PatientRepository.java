package com.example.komponente.spring.repository;

import com.example.komponente.spring.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    // FIND BY, pa odem u naziv polja u PATIENT, i vidim tamo kako se zove to polje/atribut koji zelim da uzmem
    // pazi jer ovde radi CAMEL CASE, ako ovde omasis, sve ode u k. Moras da pogodis ovde getter
    // isto kao:
    // @Query("SELECT p from Patient p where p.medicalCode =medicalCode")   !!!!!!
    // stavili smo optional<> jer mozda vrati, mozda ne vrati
    Optional<Patient> findByMedicalCode(String medicalCode);

}
