package com.hroom.check.in.service.impl;

import com.hroom.check.in.service.CheckInService;
import com.hroom.check.in.entity.CheckIn;
import com.hroom.check.in.entity.Insertion;
import com.hroom.check.in.repository.CheckInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.hroom.check.in.security.SecurityTools.isSanitized;

@Service
public class CheckInServiceImpl implements CheckInService {
    @Autowired
    CheckInRepository checkInRepository;
    @Override
    public CheckIn saveCheckIn(CheckIn checkIn) {
        return checkInRepository.save(checkIn);
    }

    @Override
    public List<CheckIn> fetchCheckInList() {
        return (List<CheckIn>) checkInRepository.findAll();
    }

    @Override
    public CheckIn updateCheckIn(CheckIn checkIn, Long checkInId) {
        Optional<CheckIn> optional = checkInRepository.findById(checkInId);
        if (optional.isEmpty()) {
            return null;
        }
        CheckIn userDB = optional.get();
        if (isSanitized(checkIn.getStartTime())) userDB.setStartTime(checkIn.getStartTime());
        return checkInRepository.save(checkIn);
    }

    @Override
    public void deleteCheckInById(Long checkInId) {

    }
}
