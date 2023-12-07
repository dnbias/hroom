package com.dnbias.hroom.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import com.dnbias.hroom.user.Tenant;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TenantServiceTests {

    @Autowired
    TenantService service;
    Tenant tenant;

    @BeforeAll
    void setUp() {
        tenant = new Tenant("user", "1234", "Bob", "Johnson",
                                   new Date(), "Turin");
    }

    @Test
    void testSaveTenant() {
        service.saveTenant(tenant);
        assert service.fetchTenantList().contains(tenant);
    }

    @Test
    void testUpdateTenant() {
        Tenant newTenant = tenant;
        newTenant.setPassword("4321");
        service.updateTenant(newTenant, tenant.getId());
    }

    @Test
    void testFindById() {
        Tenant found = service.findById(tenant.getId());
        assertEquals(tenant, found);
    }

    @Test
    void testRemoveTenant() {
        service.deleteTenantById(tenant.getId());
        assert !service.fetchTenantList().contains(tenant);
    }

}
