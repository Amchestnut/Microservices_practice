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

@Configuration  // mora configuration, da bi definisano BEAN posle
@AllArgsConstructor
public class AppRunner {

    // da li ga inicijalizujem? Ne, jer je on anotiran sa repozitory, i o njemu brine SPRING
    // ali da bi ga bi spring ukljucio, on mora da bude u KONSTRUKTORU, onda ga definisem kao @ALL ARGS CONSTRUCTOR
    // ILI da stoji @autoWired, sto znaci da ukljuci ovde objekat KOJI JE NEGDE TAMO NAPRAVIO, na nekom drugom mestu !!!
    // moze i preko gettera da se napravi, ali najbolje je da se koristi konstruktor (jer ja ocu da ga testiram, a ako radim ovako sa construktorom, super je za MOCKOVANJE)
    private DoctorRepository doctorRepository;

    @Bean
    CommandLineRunner loadData(){
        return args -> {
            Pizza p = new Pizza("testo", "fasfas", "Asfasfas");
//            // sta ja to zelim da mi ucita tokom pokretanja:
            Address address = new Address();
            Doctor d = new Doctor("Marko", "Markovic", "124124", address, Status.ACTIVE, "kardiologija");
            doctorRepository.save(d);
        };
    }

}
