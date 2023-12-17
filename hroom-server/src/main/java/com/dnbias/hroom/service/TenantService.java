package com.dnbias.hroom.service;

import com.dnbias.hroom.exception.MissingUserException;
import com.dnbias.hroom.user.Tenant;
import java.util.List;

public interface TenantService {
    Tenant saveTenant(Tenant tenant);

    List<Tenant> fetchTenantList();

    Tenant findById(Long userId) throws MissingUserException;

    Tenant updateTenant(Tenant tenant, Long userId) throws MissingUserException;

    void deleteTenantById(Long userId);
}
