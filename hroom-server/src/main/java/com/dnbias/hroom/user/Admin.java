package com.dnbias.hroom.user;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private AreaOfCompetence areaOfCompetence;

    public Admin(String username, String password, String name, String surname,
                 Date birthdate, AreaOfCompetence areaOfCompetence) {
        super(username, password, name, surname, birthdate, Capability.ADMIN);
        setAreaOfCompetence(areaOfCompetence);
    }

    public AreaOfCompetence getAreaOfCompetence() {
        return areaOfCompetence;
    }

    public void setAreaOfCompetence(AreaOfCompetence areaOfCompetence) {
        this.areaOfCompetence = areaOfCompetence;
    }

    public enum AreaOfCompetence {
        WORLD,
        NA,
        SA,
        EU,
        ASIA
    }
}
