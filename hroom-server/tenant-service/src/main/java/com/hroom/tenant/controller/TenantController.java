package com.hroom.tenant;

import com.hroom.tenant.exception.MissingUserException;
import com.hroom.tenant.service.TenantService;
import com.hroom.tenant.entity.Tenant;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping("api/v1/tenant")
@RestController
public class TenantController {

        private final Logger LOGGER = LoggerFactory.getLogger(getClass());

        @Autowired
        private TenantService service;

        @PostMapping("/tenant")
        public Tenant saveTenant(@Valid @RequestBody Tenant user) {
                LOGGER.info("TenantController > saveTenant started");
                LOGGER.info("TenantController > saveTenant > user: "+user.toString());
                return service.saveTenant(user);
        }

        @GetMapping("/tenant")
        public List<Tenant> fetchTenantList() {
                LOGGER.info("TenantController > fetchTenantList started");
                LOGGER.info("TenantController > fetchTenantList");
                return service.fetchTenantList();
        }

        @GetMapping("/tenant/{id}")
        public Tenant findTenantById(@PathVariable Long id) {
                LOGGER.info("TenantController > findTenantById started");
                LOGGER.info("TenantController > findTenantById > id: "+id);
                try {
                        return service.findById(id);
                } catch (MissingUserException e) {
                        LOGGER.info("TenantController > findTenantById > MissingUserException caught");
                        return null;
                }
        }

        @PutMapping("/tenant/{id}")
        public Tenant updateTenant(@RequestBody Tenant user,
                               @PathVariable("id") Long userId) {
                LOGGER.info("TenantController > updateTenantById started");
                LOGGER.info("TenantController > updateTenantById > user: "+user.toString());
                LOGGER.info("TenantController > updateTenantById > id: "+userId);
                try {
                        return service.updateTenant(user, userId);
                } catch (MissingUserException e) {
                        return null;
                }
        }

        @DeleteMapping("/tenant/{id}")
        public String deleteTenantById(@PathVariable("id") Long userId) {
                LOGGER.info("TenantController > deleteTenantById started");
                LOGGER.info("TenantController > deleteTenantById > id: "+userId);
                service.deleteTenantById(userId);
                return "Deleted Successfully";
        }
}
