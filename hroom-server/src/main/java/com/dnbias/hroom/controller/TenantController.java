package com.dnbias.hroom.controller;

import com.dnbias.hroom.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import com.dnbias.hroom.user.Tenant;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TenantController {

        @Autowired
        private TenantService service;

        @PostMapping("/tenant")
        public Tenant saveTenant(@Valid @RequestBody Tenant user) {
                return service.saveTenant(user);
        }

        @GetMapping("/tenant")
        public List<Tenant> fetchTenantList()
        {
                return service.fetchTenantList();
        }

        @PutMapping("/tenant/{id}")
        public Tenant updateUser(@RequestBody Tenant user,
                               @PathVariable("id") Long userId)
        {
                return service.updateTenant(user, userId);
        }

        @DeleteMapping("/tenant/{id}")
        public String deleteUserById(@PathVariable("id") Long userId)
        {
                service.deleteTenantById(userId);
                return "Deleted Successfully";
        }
}
