package com.example.komponente.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
public class Pizza {
    private String ukus;
    private String velicina;
    private String nesto;

    public Pizza() {
    }

    public String getUkus() {
        return ukus;
    }

    public void setUkus(String ukus) {
        this.ukus = ukus;
    }

    public String getVelicina() {
        return velicina;
    }

    public void setVelicina(String velicina) {
        this.velicina = velicina;
    }

    public String getNesto() {
        return nesto;
    }

    public void setNesto(String nesto) {
        this.nesto = nesto;
    }
}
