package com.example.komponente.spring;

import com.example.komponente.spring.domain.Address;
import com.example.komponente.spring.domain.Doctor;
import com.example.komponente.spring.domain.Status;
import com.example.komponente.spring.repository.DoctorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DoctorRepositoryTest {
    @Autowired
    private DoctorRepository doctorRepository;

    @Test
    public void testSaveDoctor() {
        Address address = new Address("123 Main St", "City", "State", "12345");
//        Doctor doctor = new Doctor("Cardiology");
//        Doctor saved = doctorRepository.save(doctor);
//        assertNotNull(saved);
//        assertNotNull(saved.getId());
    }
}
