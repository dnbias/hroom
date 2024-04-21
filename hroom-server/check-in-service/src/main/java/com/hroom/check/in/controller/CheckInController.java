package com.hroom.check.in.controller;

import com.hroom.check.in.entity.CheckIn;
import com.hroom.check.in.service.CheckInService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CheckInController {
    @Autowired
    private CheckInService service;

    @PostMapping("/checkIn")
    public CheckIn saveCheckIn(@Valid @RequestBody CheckIn checkIn)
    {
        return service.saveCheckIn(checkIn);
    }

    @GetMapping("/checkOut")
    public List<CheckIn> fetchCheckInList()
    {
        return service.fetchCheckInList();
    }

    // Update operation
    @PutMapping("/checkIn/{id}")
    public CheckIn updateUser(@RequestBody CheckIn checkIn,
                           @PathVariable("id") Long checkInId)
    {
        return service.updateCheckIn(checkIn, checkInId);
    }

    // Delete operation
    @DeleteMapping("/checkIn/{id}")
    public String deleteCheckInById(@PathVariable("id") Long checkInId)
    {
        service.deleteCheckInById(checkInId);
        return "Deleted Successfully";
    }
}
