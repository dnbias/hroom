package com.dnbias.hroom.controller;

import com.dnbias.hroom.room.Insertion;
import com.dnbias.hroom.service.InsertionService;
import com.dnbias.hroom.service.TenantService;
import com.dnbias.hroom.user.Tenant;
import com.dnbias.hroom.user.User;
import jakarta.validation.Valid;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class InsertionController {
    @Autowired
    private InsertionService service;

    @PostMapping("/create-insertion")
    public Insertion saveI(@Valid @RequestBody Insertion insertion)
    {
        return service.saveInsertion(insertion);
    }

    @GetMapping("/insertionList")
    public List<Insertion> fetchInsertList()
    {
        return service.fetchInsertionList();
    }

    // Update operation
    @PutMapping("/insertion/{id}")
    public Insertion updateInsertion(@RequestBody  Insertion insertion,
                           @PathVariable("id") Long InsertionId)
    {
        return service.updateInsertion(insertion, InsertionId);
    }

    // Delete operation
    @DeleteMapping("/insertion/{id}")
    public String deleteInsertById(@PathVariable("id") Long insertionId)
    {
        service.deleteInsertionById(insertionId);
        return "Deleted Successfully";
    }
}
