package com.dnbias.hroom.service;


import java.util.List;

import com.dnbias.hroom.reservation.Reservation;

public interface ReservationService {
    Reservation saveReservation(Reservation reservation);

    List<Reservation> fetchReservationList();

    Reservation updateReservation(Reservation reservation, Long reservationId);

    void deleteReservationById(Long reservationId);
}
