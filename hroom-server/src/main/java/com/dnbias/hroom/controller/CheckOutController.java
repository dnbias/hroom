package com.dnbias.hroom.controller;

import com.dnbias.hroom.check.CheckOut;
import com.dnbias.hroom.service.CheckOutService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CheckOutController {
    @Autowired
    private CheckOutService service;

    @PostMapping("/checkOut")
    public CheckOut saveCheckOut(@Valid @RequestBody CheckOut checkOut)
    {
        return service.saveCheckOut(checkOut);
    }

    @GetMapping("/checkOut")
    public List<CheckOut> fetchCheckOutList()
    {
        return service.fetchCheckOutList();
    }

    // Update operation
    @PutMapping("/checkOut/{id}")
    public CheckOut updateUser(@RequestBody CheckOut checkOut,
                           @PathVariable("id") Long checkOutId)
    {
        return service.updateCheckOut(checkOut, checkOutId);
    }

    // Delete operation
    @DeleteMapping("/checkOut/{id}")
    public String deleteCheckOutById(@PathVariable("id") Long checkOutId)
    {
        service.deleteCheckOut(checkOutId);
        return "Deleted Successfully";
    }
}
