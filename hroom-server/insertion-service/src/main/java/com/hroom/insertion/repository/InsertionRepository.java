package com.hroom.insertion.repository;

import com.hroom.insertion.entity.Insertion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsertionRepository extends CrudRepository<Insertion, Long> {
}
