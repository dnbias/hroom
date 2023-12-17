package com.dnbias.hroom.service;

import java.util.List;

import com.dnbias.hroom.reservation.CheckOut;

public interface CheckOutService {
    CheckOut saveCheckOut(CheckOut checkOut);

    List<CheckOut> fetchCheckOutList();

    CheckOut updateCheckOut(CheckOut checkOut, Long checkOutId);

    void deleteCheckOutById(Long checkOutId);
}
