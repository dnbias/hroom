package com.hroom.admin.controller;

import com.hroom.admin.service.AdminService;
import com.hroom.admin.entity.Admin;
import com.hroom.admin.entity.Tenant;
import com.hroom.admin.entity.User;
import com.hroom.admin.exception.MissingUserException;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping("api/v1")
@RestController
public class AdminController {
    @Autowired
    private AdminService service;
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @PostMapping("/admin")
    public Admin saveAdmin(@Valid @RequestBody Admin user){
        LOGGER.info("AdminController > saveAdmin started");
        LOGGER.info("AdminController > saveAdmin > user: "+user.toString());
        return  service.saveAdmin(user);
    }

    @GetMapping("/admin")
    public List<Admin> fetchAdminList(){
        LOGGER.info("AdminController > fetchAdminList started");
        return service.fetchAdminList();
    }

    @PutMapping("/admin/{id}")
    public Admin updateAdmin(@RequestBody Admin user,
                           @PathVariable("id") Long userId)
    {
        LOGGER.info("AdminController > updateAdminById started");
        LOGGER.info("AdminController > updateAdminById > user: "+user.toString());
        LOGGER.info("AdminController > updateAdminById > id: "+userId);
        try {
            return service.updateAdmin(user, userId);
        } catch (MissingUserException e) {
            return null;
        }
    }

    @DeleteMapping("/admin/{id}")
    public String deleteAdminById(@PathVariable("id") Long userId)
    {
        LOGGER.info("AdminController > deleteAdminById started");
        LOGGER.info("AdminController > deleteAdminById > id: "+userId);
        service.deleteAdminById(userId);
        return "Deleted Successfully";
    }

    @DeleteMapping("/ban/{id}")
    public String banUserById(@PathVariable("id") Long userId) {
        LOGGER.info("AdminController > banUserById started");
        LOGGER.info("AdminController > banUserById > id: "+userId);
        service.banUserById(userId);
        return "User banned";
    }
}
