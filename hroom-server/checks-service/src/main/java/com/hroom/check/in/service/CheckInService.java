package com.dnbias.hroom.service;

import java.util.List;

import com.dnbias.hroom.reservation.CheckIn;

public interface CheckInService {
    CheckIn saveCheckIn(CheckIn checkIn);

    List<CheckIn> fetchCheckInList();

    CheckIn updateCheckIn(CheckIn checkIn, Long checkInId);

    void deleteCheckInById(Long checkInId);
}
