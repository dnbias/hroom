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

    public Admin(String username, String password, String name, String surname, Date birthdate,
                 Long userId, String areaOfCompetence) {
        super(username, password, name, surname, birthdate, userId, Capability.ADMIN);
        setAreaOfCompetence(areaOfCompetence);
    }
    private String areaOfCompetence;

    public String getAreaOfCompetence() {
        return areaOfCompetence;
    }

    public void setAreaOfCompetence(String areaOfCompetence) {
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
