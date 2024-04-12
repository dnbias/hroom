package com.hroom.admin.entity;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private AreaOfCompetence areaOfCompetence;

    public enum AreaOfCompetence {
        WORLD,
        NA,
        SA,
        EU,
        ASIA
    }
}
