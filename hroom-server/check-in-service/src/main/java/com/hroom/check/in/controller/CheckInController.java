package com.hroom.check.in.controller;

import com.hroom.check.in.entity.CheckIn;
import com.hroom.check.in.service.CheckInService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping("api/v1")
@RestController
public class CheckInController {
    @Autowired
    private CheckInService service;
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @PostMapping("/checkIn")
    public CheckIn saveCheckIn(@Valid @RequestBody CheckIn checkIn)
    {
        LOGGER.info("CheckInController > saveCheckIn started");
        LOGGER.info("CheckInController > saveCheckIn > checkIn: "+checkIn.toString());
        return service.saveCheckIn(checkIn);
    }

    @GetMapping("/checkIn")
    public List<CheckIn> fetchCheckInList()
    {
        LOGGER.info("CheckInController > fetchCheckInList started");
        LOGGER.info("CheckInController > fetchCheckInList");
        return service.fetchCheckInList();
    }

    @PutMapping("/checkIn/{id}")
    public CheckIn updateCheckIn(@RequestBody CheckIn checkIn,
                           @PathVariable("id") Long checkInId)
    {
        LOGGER.info("CheckInController > updateCheckInById started");
        LOGGER.info("CheckInController > updateCheckInById > checkIn: "+checkIn.toString());
        LOGGER.info("CheckInController > updateCheckInById > id: "+checkInId);
        return service.updateCheckIn(checkIn, checkInId);
    }

    @DeleteMapping("/checkIn/{id}")
    public String deleteCheckInById(@PathVariable("id") Long checkInId)
    {
        LOGGER.info("CheckInController > deleteCheckInById started");
        LOGGER.info("CheckInController > deleteCheckInById > id: "+checkInId);
        service.deleteCheckInById(checkInId);
        return "Deleted Successfully";
    }
}
