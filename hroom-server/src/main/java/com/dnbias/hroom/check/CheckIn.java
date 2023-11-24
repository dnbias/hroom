package com.dnbias.hroom.check;

import java.time.LocalDate;
import java.time.LocalTime;

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
