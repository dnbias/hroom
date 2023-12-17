<<<<<<<< HEAD:hroom-server/src/main/java/com/dnbias/hroom/reservation/GeneralCheck.java
package com.dnbias.hroom.reservation;
========
package com.dnbias.hroom.check;
>>>>>>>> 3d9cfcd (Ora funziona se no sclero):hroom-server/src/main/java/com/dnbias/hroom/check/GeneralCheck.java

import java.time.LocalDate;
import java.time.LocalTime;

<<<<<<<< HEAD:hroom-server/src/main/java/com/dnbias/hroom/reservation/GeneralCheck.java
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
========
>>>>>>>> 3d9cfcd (Ora funziona se no sclero):hroom-server/src/main/java/com/dnbias/hroom/check/GeneralCheck.java
public abstract class GeneralCheck {
    private LocalDate setDate;
    private LocalTime setTime;

    public LocalDate getSetDate() {
        return setDate;
    }

    public void setSetDate(LocalDate setDate) {
        this.setDate = setDate;
    }

    public LocalTime getSetTime() {
        return setTime;
    }

    public void setSetTime(LocalTime setTime) {
        this.setTime = setTime;
    }
}
