package com.spike.springboot.hroom.demo.check;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class CheckIn extends GeneralCheck {
   private  LocalDate startDate;
   private LocalTime startTime;


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
