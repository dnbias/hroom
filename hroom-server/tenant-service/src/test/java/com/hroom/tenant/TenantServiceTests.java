package com.hroom.tenant;

import com.hroom.tenant.exception.MissingUserException;
import com.hroom.tenant.entity.Tenant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.Date;
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
        try {
            service.updateTenant(newTenant, tenant.getId());
        } catch (MissingUserException e) {
            assertFalse(true);
        }
    }

    @Test
    void testFindById() {
        try {
            Tenant found = service.findById(tenant.getId());
            assertEquals(tenant, found);
        } catch (MissingUserException e) {
            assertFalse(true);
        }
    }

    @Test
    void testRemoveTenant() {
        service.deleteTenantById(tenant.getId());
        assert !service.fetchTenantList().contains(tenant);
    }

}
