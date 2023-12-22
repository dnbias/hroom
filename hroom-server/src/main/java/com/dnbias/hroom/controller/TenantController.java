package com.dnbias.hroom.controller;
import com.dnbias.hroom.exception.MissingUserException;
import com.dnbias.hroom.service.TenantService;
import com.dnbias.hroom.user.Tenant;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

        @GetMapping("/tenant/{id}")
        public Tenant fetchTenantList(@PathVariable Long id)
        {
                try {
                        return service.findById(id);
                } catch (MissingUserException e) {
                        return null;
                }
        }

        @PutMapping("/tenant/{id}")
        public Tenant updateUser(@RequestBody Tenant user,
                               @PathVariable("id") Long userId)
        {
                try {
                        return service.updateTenant(user, userId);
                } catch (MissingUserException e) {
                        return null;
                }
        }

        @DeleteMapping("/tenant/{id}")
        public String deleteUserById(@PathVariable("id") Long userId)
        {
                service.deleteTenantById(userId);
                return "Deleted Successfully";
        }
}
