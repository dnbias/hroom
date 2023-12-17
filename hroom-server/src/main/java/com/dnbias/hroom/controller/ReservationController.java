package com.dnbias.hroom.controller;

import com.dnbias.hroom.reservation.Reservation;
import com.dnbias.hroom.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ReservationController {
    @Autowired
    private ReservationService service;

    @PostMapping("/reservation")
    public Reservation saveReservation(@Valid @RequestBody Reservation reservation)
    {
        return service.saveReservation(reservation);
    }

    @GetMapping("/reservation")
    public List<Reservation> fetchReservationList()
    {
        return service.fetchReservationList();
    }

    // Update operation
    @PutMapping("/reservation/{id}")
    public Reservation updateReservation(@RequestBody Reservation reservation,
                           @PathVariable("id") Long reservationId)
    {
        return service.updateReservation(reservation, reservationId);
    }

    // Delete operation
    @DeleteMapping("/reservation/{id}")
    public String deleteUserById(@PathVariable("id") Long reservationId)
    {
        service.deleteReservationById(reservationId);
        return "Deleted Successfully";
    }
}
