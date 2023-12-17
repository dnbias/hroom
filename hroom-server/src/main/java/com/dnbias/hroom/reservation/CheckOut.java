<<<<<<<< HEAD:hroom-server/src/main/java/com/dnbias/hroom/reservation/CheckOut.java
package com.dnbias.hroom.reservation;
========
package com.dnbias.hroom.check;
>>>>>>>> 3d9cfcd (Ora funziona se no sclero):hroom-server/src/main/java/com/dnbias/hroom/check/CheckOut.java

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
