package com.example.komponente.spring.runner;

import com.example.komponente.spring.domain.Address;
import com.example.komponente.spring.domain.Doctor;
import com.example.komponente.spring.domain.Pizza;
import com.example.komponente.spring.domain.Status;
import com.example.komponente.spring.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppRunner {

    private final DoctorRepository doctorRepository;

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
        };
    }
}
