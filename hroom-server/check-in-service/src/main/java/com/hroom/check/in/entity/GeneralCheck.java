package com.hroom.check.in.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
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
