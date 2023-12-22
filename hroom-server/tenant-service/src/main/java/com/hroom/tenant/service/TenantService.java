package com.hroom.tenant.service;

import com.hroom.tenant.exception.MissingUserException;
import com.hroom.tenant.entity.Tenant;
import java.util.List;

public interface TenantService {
    Tenant saveTenant(Tenant tenant);

    List<Tenant> fetchTenantList();

    Tenant findById(Long userId) throws MissingUserException;

    Tenant updateTenant(Tenant tenant, Long userId) throws MissingUserException;

    void deleteTenantById(Long userId);
}
