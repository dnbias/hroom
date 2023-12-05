package com.dnbias.hroom.controller;

import com.dnbias.hroom.room.Insertion;
import com.dnbias.hroom.service.InsertionService;
import com.dnbias.hroom.service.LandlordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LandlordController {
    @Autowired
    LandlordService landlordService;
    @Autowired
    InsertionService insertionService;

    void createInsertion(Insertion insertion) {
        insertionService.saveInsertion(insertion);
    }

    void deleteInsertionById(Long insertionId) {
        insertionService.deleteInsertionById(insertionId);
    }
}
