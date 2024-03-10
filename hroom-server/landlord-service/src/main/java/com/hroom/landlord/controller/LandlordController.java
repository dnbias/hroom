package com.dnbias.hroom.controller;

import com.dnbias.hroom.room.Insertion;
import com.dnbias.hroom.service.InsertionService;
import com.dnbias.hroom.service.LandlordService;

import com.dnbias.hroom.user.Landlord;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LandlordController {
     @Autowired
    private  LandlordService service;

    @PostMapping("/landlord")
    public Landlord saveLandLord(@Valid @RequestBody Landlord user){
        return service.saveLandlord(user);
    }

    @GetMapping("/landlord")
    public List<Landlord> fetchLandLordList()
    {
        return service.fetchLandlordList();
    }
    @PutMapping("/landlord/{id}")
    public Landlord updateLandlord(@RequestBody Landlord user,
                           @PathVariable("id") Long userId)
    {
        return service.updateLandlord(user, userId);
    }
    @DeleteMapping("/landlord/{id}")
    public String deleteLandlordById(@PathVariable("id") Long userId)
    {
        service.deleteLandlordById((userId));
        return "Deleted Successfully";
    }
}
