<<<<<<<< HEAD:hroom-server/src/main/java/com/dnbias/hroom/reservation/CheckIn.java
package com.dnbias.hroom.reservation;

import java.time.LocalDate;
import java.time.LocalTime;
========
package com.dnbias.hroom.check;

import java.time.LocalDate;
import java.time.LocalTime;

public class CheckIn extends GeneralCheck {
   private  LocalDate startDate;
   private LocalTime startTime;
>>>>>>>> 3d9cfcd (Ora funziona se no sclero):hroom-server/src/main/java/com/dnbias/hroom/check/CheckIn.java

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CheckIn extends GeneralCheck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private LocalDate startDate;
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
