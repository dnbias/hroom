package com.dnbias.hroom.repository;

import com.dnbias.hroom.reservation.CheckIn;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckInRepository extends CrudRepository<CheckIn, Long> {
}
