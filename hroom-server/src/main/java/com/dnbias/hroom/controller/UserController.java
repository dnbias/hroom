package com.dnbias.hroom.controller;

import com.dnbias.hroom.service.TenantService;
import com.dnbias.hroom.user.Tenant;
import com.dnbias.hroom.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private TenantService service;

    @PostMapping("/users")
    public User saveUser(@Valid @RequestBody Tenant user)
    {
        return service.saveTenant(user);
    }

    @GetMapping("/users")
    public List<Tenant> fetchUserList()
    {
        return service.fetchTenantList();
    }

    // Update operation
    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody Tenant user,
                           @PathVariable("id") Long userId)
    {
        return service.updateTenant(user, userId);
    }

    // Delete operation
    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable("id") Long userId)
    {
        service.deleteTenantById(userId);
        return "Deleted Successfully";
    }
}
