package com.dnbias.hroom.service;

import com.dnbias.hroom.check.CheckOut;
import com.dnbias.hroom.repository.CheckOutRepository;
import com.dnbias.hroom.room.Insertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.dnbias.hroom.security.SecurityTools.isSanitized;

@Service
public class CheckOutServiceImpl implements CheckOutService {
    @Autowired
    CheckOutRepository checkOutRepository;
    @Override
    public CheckOut saveCheckOut(CheckOut checkOut) {
        return checkOutRepository.save(checkOut);
    }

    @Override
    public List<CheckOut> fetchCheckOutList() {
        return (List<CheckOut>) checkOutRepository.findAll();
    }

    @Override
    public CheckOut updateCheckOut(CheckOut checkOut, Long checkOutId) {
        Optional<CheckOut> optional = checkOutRepository.findById(checkOutId);
        if (optional.isEmpty()) {
            return null;
        }
        CheckOut userDB = optional.get();
        if (isSanitized(checkOut.getStartTime())) userDB.setStartTime(checkOut.getStartTime());
        return checkOutRepository.save(checkOut);
    }

    @Override
    public void deleteCheckOut(Long userId) {

    }
}
