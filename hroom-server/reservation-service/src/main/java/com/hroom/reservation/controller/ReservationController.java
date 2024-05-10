package com.hroom.reservation.controller;

import com.hroom.reservation.entity.Reservation;
import com.hroom.reservation.service.ReservationService;
import com.hroom.reservation.exception.MissingReservationException;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RequestMapping("api/v1")
@RestController
public class ReservationController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private ReservationService service;

    @PostMapping("/reservation")
    public Reservation saveReservation(@Valid @RequestBody Reservation reservation)
    {
        LOGGER.info("ReservationController > saveReservation started");
        LOGGER.info("ReservationController > saveReservation > reservation: "
                    + reservation.toString());
        return service.saveReservation(reservation);
    }

    @GetMapping("/reservation")
    public List<Reservation> fetchReservationList()
    {
        LOGGER.info("ReservationController > fetchReservationList started");
        LOGGER.info("ReservationController > fetchReservationList");
        return service.fetchReservationList();
    }

    @GetMapping("/reservation/{id}")
    public Reservation findReservationById(@PathVariable Long id) {
        LOGGER.info("ReservationController > findReservationById started");
        LOGGER.info("ReservationController > findReservationById > id: " + id);
        try {
            return service.findById(id);
        } catch (MissingReservationException e) {
            LOGGER.info("ReservationController > findReservationById > MissingReservationException caught");
            return null;
        }
    }

    @PutMapping("/reservation/{id}")
    public Reservation updateReservation(@RequestBody Reservation reservation,
                           @PathVariable("id") Long reservationId)
    {
        LOGGER.info("ReservationController > updateReservationById started");
        LOGGER.info("ReservationController > updateReservationById > user: " + reservation.toString());
        LOGGER.info("ReservationController > updateReservationById > id: " + reservationId);
        try {
            return service.updateReservation(reservation, reservationId);
        } catch (MissingReservationException e) {
            LOGGER.info("ReservationController > updateReservationById > MissingReservationException caught");
            return null;
        }
    }

    @DeleteMapping("/reservation/{id}")
    public String deleteUserById(@PathVariable("id") Long reservationId)
    {
        LOGGER.info("ReservationController > deleteReservationById started");
        LOGGER.info("ReservationController > deleteReservationById > id: " + reservationId);
        service.deleteReservationById(reservationId);
        return "Deleted Successfully";
    }
}
