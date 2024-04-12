package com.hroom.check.in.service;

import java.util.List;

import com.hroom.check.in.entity.CheckIn;

public interface CheckInService {
    CheckIn saveCheckIn(CheckIn checkIn);

    List<CheckIn> fetchCheckInList();

    CheckIn updateCheckIn(CheckIn checkIn, Long checkInId);

    void deleteCheckInById(Long checkInId);
}
