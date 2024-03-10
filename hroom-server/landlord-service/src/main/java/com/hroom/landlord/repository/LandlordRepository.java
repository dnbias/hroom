package com.dnbias.hroom.repository;

import com.dnbias.hroom.user.Landlord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandlordRepository extends CrudRepository<Landlord, Long> {
}
