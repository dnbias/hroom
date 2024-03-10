package com.hroom.insertion.controller;

import com.hroom.insertion.entity.Insertion;
// import com.hroom.insertion.entity.Tenant;
// import com.hroom.insertion.entity.User;
import com.hroom.insertion.service.InsertionService;
import com.hroom.insertion.service.TenantService;
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
    public Insertion saveInsertion(@Valid @RequestBody Insertion insertion)
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
    public String deleteInsertionById(@PathVariable("id") Long insertionId)
    {
        service.deleteInsertionById(insertionId);
        return "Deleted Successfully";
    }
}
