package com.spike.springboot.hroom.demo.check;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
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
