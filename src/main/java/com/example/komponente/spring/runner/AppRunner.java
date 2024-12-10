package com.example.komponente.spring.runner;

import com.example.komponente.spring.domain.*;
import com.example.komponente.spring.repository.DoctorRepository;
import com.example.komponente.spring.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppRunner {

    private final DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    // Constructor injection without Lombok
    public AppRunner(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Bean
    CommandLineRunner loadData(){
        return args -> {
            Address address = new Address();
            Doctor d = new Doctor("Marko", "Markovic", "124124", address, Status.ACTIVE, "kardiologija");
            doctorRepository.save(d); // doctorRepository will not be null now

            Patient patient = new Patient("Pera", "Peric", "1111", address, Status.ACTIVE, "1235");
            patientRepository.save(patient);

            // medical code je isti, ali bi generalno trebao da stoji neki UNIQUE CONSTRAINT koji bi ovo zabranio
            Patient patient2 = new Patient("Pera23", "Peric123", "1111", address, Status.ACTIVE, "1235");
            patientRepository.save(patient2);

        };
    }
}
