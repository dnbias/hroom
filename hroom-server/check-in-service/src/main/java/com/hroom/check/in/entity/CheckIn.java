package com.hroom.check.in.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class CheckIn extends GeneralCheck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
   private  LocalDate startDate;
   private LocalTime startTime;

    public CheckIn(Long id, LocalDate startDate, LocalTime startTime) {
        this.id = id;
        this.startDate = startDate;
        this.startTime = startTime;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
}
