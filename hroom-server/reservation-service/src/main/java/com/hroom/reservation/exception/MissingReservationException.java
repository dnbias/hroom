package com.hroom.reservation.exception;

public class MissingReservationException extends BusinessException {
    public MissingReservationException(Long id){
        super("MissingReservationException: " + id);
    }
}
