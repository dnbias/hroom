package com.dnbias.hroom.room;

import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private int weekdays;
    private LocalDate timeStart;
    private LocalDate timeEnd;
    private ArrayList<LocalDate> daysNotAvailable;

    public Availability(int weekdays, LocalDate timeStart, LocalDate timeEnd,
                        ArrayList<LocalDate> daysNotAvailable) {
        this.weekdays = weekdays;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.daysNotAvailable = daysNotAvailable;
    }

    public int getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(int weekdays) {
        this.weekdays = weekdays;
    }

    public LocalDate getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalDate timeStart) {
        this.timeStart = timeStart;
    }

    public LocalDate getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalDate timeEnd) {
        this.timeEnd = timeEnd;
    }

    public ArrayList<LocalDate> getDaysNotAvailable() {
        return daysNotAvailable;
    }

    public void setDaysNotAvailable(ArrayList<LocalDate> daysNotAvailable) {
        this.daysNotAvailable = daysNotAvailable;
    }

}
