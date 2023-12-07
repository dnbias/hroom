package com.dnbias.hroom.repository;

import com.dnbias.hroom.room.Insertion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsertionRepository extends CrudRepository<Insertion, Long> {
}
