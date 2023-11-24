package com.dnbias.hroom.room;

import java.time.LocalDate;

public class Availability {

    public Availability(int weekdays, LocalDate timeStart, LocalDate timeEnd, LocalDate daysNotAvailable) {
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

    public LocalDate getDaysNotAvailable() {
        return daysNotAvailable;
    }

    public void setDaysNotAvailable(LocalDate daysNotAvailable) {
        this.daysNotAvailable = daysNotAvailable;
    }

    private int weekdays;

    private LocalDate timeStart;
    private LocalDate timeEnd;

    private LocalDate daysNotAvailable;

}
