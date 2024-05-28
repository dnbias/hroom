package com.hroom.reservation.repository;

import com.hroom.reservation.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
@Repository
public interface CheckInRepository extends CrudRepository<CheckIn, Long> {
}

