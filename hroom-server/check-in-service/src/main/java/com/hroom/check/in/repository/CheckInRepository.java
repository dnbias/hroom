package com.hroom.check.in.repository;

import com.hroom.check.in.entity.CheckIn;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckInRepository extends CrudRepository<CheckIn, Long> {
}
