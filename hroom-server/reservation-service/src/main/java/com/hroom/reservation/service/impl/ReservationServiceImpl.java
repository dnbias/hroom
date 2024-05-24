package com.dnbias.hroom.service.impl;

import com.hroom.reservation.service.ReservationService;
import com.hroom.reservation.repository.ReservationRepository;
import com.hroom.reservation.entity.Reservation;
import com.hroom.reservation.exception.MissingReservationException;
import com.hroom.reservation.entity.Insertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.hroom.reservation.security.SecurityTools.isSanitized;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    ReservationRepository repository;
    @Override
    public Reservation saveReservation(Reservation reservation) {
        LOGGER.info("ReservationServiceImpl > saveReservation started");
        return repository.save(reservation);
    }

    @Override
    public List<Reservation> fetchReservationList() {
        LOGGER.info("ReservationServiceImpl > fetchReservationList started");
        return (List<Reservation>) repository.findAll();
    }

    @Override
    public Reservation findById(Long id) throws MissingReservationException {
        LOGGER.info("ReservationServiceImpl > findById started");
        Optional<Reservation> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new MissingReservationException(id);
        }
        return optional.get();
    }

    @Override
    public Reservation updateReservation(Reservation reservation, Long reservationId)
        throws MissingReservationException {

        LOGGER.info("ReservationServiceImpl > updateReservation started");

        Optional<Reservation> optional = repository.findById(reservationId);
        if (optional.isEmpty()) {
            throw new MissingReservationException(reservationId);
        }

        Reservation reservationDB = optional.get();
        if (isSanitized(reservation.getCheckInId()))
            reservationDB.setCheckInId(reservation.getCheckInId());
        if (isSanitized(reservation.getCheckOutId()))
            reservationDB.setCheckOutId(reservation.getCheckOutId());
        return repository.save(reservation);
    }

    @Override
    public void deleteReservationById(Long reservationId) {
        LOGGER.info("ReservationServiceImpl > deleteReservationById started");
        repository.deleteById(reservationId);
    }

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
