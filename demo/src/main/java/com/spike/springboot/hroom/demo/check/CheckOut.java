package com.spike.springboot.hroom.demo.check;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

public class CheckOut extends GeneralCheck{
    private LocalDate endDate;
    private LocalTime startTime;

    public CheckOut(LocalDate endDate, LocalTime startTime) {
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
