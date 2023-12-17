package com.dnbias.hroom.repository;

import com.dnbias.hroom.reservation.CheckOut;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckOutRepository extends CrudRepository<CheckOut, Long> {
}
