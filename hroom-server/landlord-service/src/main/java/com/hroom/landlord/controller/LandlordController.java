package com.hroom.landlord.controller;

import com.hroom.landlord.entity.Landlord;
import com.hroom.landlord.entity.Insertion;
import com.hroom.landlord.service.LandlordService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RequestMapping("api/v1")
@RestController
public class LandlordController {
     @Autowired
    private  LandlordService service;
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @PostMapping("/landlord")
    public Landlord saveLandLord(@Valid @RequestBody Landlord user){
        LOGGER.info("LandlordController > saveLandlord started");
        LOGGER.info("LandlordController > saveLandlord > user: "+user.toString());
        return service.saveLandlord(user);
    }

    @GetMapping("/landlord")
    public List<Landlord> fetchLandLordList()
    {
        LOGGER.info("LandlordController > fetchLandlordList started");
        LOGGER.info("LandlordController > fetchLandlordList");
        return service.fetchLandlordList();
    }

    @PutMapping("/landlord/{id}")
    public Landlord updateLandlord(@RequestBody Landlord user,
                           @PathVariable("id") Long userId)
    {
        LOGGER.info("LandlordController > updateLandlordById started");
        LOGGER.info("LandlordController > updateLandlordById > user: "+user.toString());
        LOGGER.info("LandlordController > updateLandlordById > id: "+userId);
        return service.updateLandlord(user, userId);
    }

    @DeleteMapping("/landlord/{id}")
    public String deleteLandlordById(@PathVariable("id") Long userId)
    {
        LOGGER.info("LandlordController > deleteLandlordById started");
        LOGGER.info("LandlordController > deleteLandlordById > id: "+userId);
        service.deleteLandlordById((userId));
        return "Deleted Successfully";
    }
}
