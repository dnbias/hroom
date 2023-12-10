package com.dnbias.hroom.controller;

import com.dnbias.hroom.service.AdminService;
import com.dnbias.hroom.user.Admin;
import com.dnbias.hroom.user.Tenant;
import com.dnbias.hroom.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminService service;
    @PostMapping("/admins")
    public Admin saveAdmin(@Valid @RequestBody Admin user){
        return  service.saveAdmin(user);
    }
    @GetMapping("/users")
    public List<Admin> fetchUserList(){
        return service.fetchAdminList();
    }
    @PutMapping("/admin/{id}")
    public Admin updateadmin(@RequestBody Admin user,
                           @PathVariable("id") Long userId)
    {
        return service.updateAdmin(user, userId);
    }
    @DeleteMapping("/admin/{id}")
    public String deleteUserById(@PathVariable("id") Long userId)
    {
        service.deleteAdminById(userId);
        return "Deleted Successfully";
    }
    //todo come la gestiamo
   // public void banUserById(Long userId) {*/


}
