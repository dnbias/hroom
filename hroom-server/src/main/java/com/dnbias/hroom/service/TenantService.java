package com.dnbias.hroom.service;

import com.dnbias.hroom.user.Tenant;
import java.util.List;

public interface TenantService {
    Tenant saveTenant(Tenant tenant);

    List<Tenant> fetchTenantList();

    Tenant updateTenant(Tenant tenant, Long userId);

    void deleteTenantById(Long userId);
}
