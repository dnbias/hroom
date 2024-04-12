package com.hroom.landlord.repository;

import com.hroom.landlord.entity.Landlord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandlordRepository extends CrudRepository<Landlord, Long> {
}
