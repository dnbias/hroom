package com.hroom.tenant.repository;

import com.hroom.tenant.entity.Tenant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends CrudRepository<Tenant, Long> {
}
