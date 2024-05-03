package com.hroom.reservation.service;

import com.hroom.reservation.entity.Reservation;
import com.hroom.reservation.exception.MissingReservationException;

import java.util.List;

public interface ReservationService {
    Reservation saveReservation(Reservation reservation);

    List<Reservation> fetchReservationList();

    public Reservation findById(Long id)
        throws MissingReservationException;

    Reservation updateReservation(Reservation reservation, Long reservationId)
        throws MissingReservationException;

    void deleteReservationById(Long reservationId);
}
