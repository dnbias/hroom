package com.dnbias.hroom.service;

import com.hroom.reservation.service.ReservationService;
import com.hroom.reservation.repository.ReservationRepository;
import com.hroom.reservation.entity.Reservation;
import com.hroom.reservation.entity.Insertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.hroom.reservation.security.SecurityTools.isSanitized;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;
    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> fetchReservationList() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation reservation, Long reservationId) {
        Optional<Reservation> optional = reservationRepository.findById(reservationId);
        if (optional.isEmpty()) {
            return null;
        }
        Reservation reservationDB = optional.get();
        if (isSanitized(reservation.getCheckInId())) reservationDB.setCheckInId(reservation.getCheckInId());
        if (isSanitized(reservation.getCheckOutId())) reservationDB.setCheckOutId(reservation.getCheckOutId());
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservationById(Long reservationId) {
        reservationRepository.deleteById(reservationId);

    }
}
