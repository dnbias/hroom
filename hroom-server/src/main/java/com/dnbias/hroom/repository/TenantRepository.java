package com.dnbias.hroom.repository;

import com.dnbias.hroom.user.Tenant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends CrudRepository<Tenant, Long> {
}
