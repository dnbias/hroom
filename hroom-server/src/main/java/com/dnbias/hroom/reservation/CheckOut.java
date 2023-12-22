package com.dnbias.hroom.reservation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class CheckOut extends GeneralCheck{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private LocalDate endDate;
    private LocalTime startTime;


    public CheckOut(Long id, LocalDate endDate, LocalTime startTime) {
        this.id = id;
        this.endDate = endDate;
        this.startTime = startTime;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
}
