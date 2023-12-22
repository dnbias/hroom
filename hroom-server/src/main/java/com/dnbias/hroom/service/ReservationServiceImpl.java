package com.dnbias.hroom.service;

import com.dnbias.hroom.repository.ReservationRepository;
import com.dnbias.hroom.reservation.Reservation;
import com.dnbias.hroom.room.Insertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.dnbias.hroom.security.SecurityTools.isSanitized;

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
        Reservation userDB = optional.get();
        if (isSanitized(reservation.getCheckIn())) userDB.setCheckIn(reservation.getCheckIn());
        if (isSanitized(reservation.getCheckOut())) userDB.setCheckOut(reservation.getCheckOut());
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservationById(Long reservationId) {
        reservationRepository.deleteById(reservationId);

    }
}
