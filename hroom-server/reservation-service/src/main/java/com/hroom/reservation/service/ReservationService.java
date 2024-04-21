package com.hroom.reservation.service;


import java.util.List;

import com.hroom.reservation.entity.Reservation;

public interface ReservationService {
    Reservation saveReservation(Reservation reservation);

    List<Reservation> fetchReservationList();

    Reservation updateReservation(Reservation reservation, Long reservationId);

    void deleteReservationById(Long reservationId);
}
