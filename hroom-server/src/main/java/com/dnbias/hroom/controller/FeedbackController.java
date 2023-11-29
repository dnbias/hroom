package com.dnbias.hroom.controller;


import com.dnbias.hroom.feedback.Feedback;
import com.dnbias.hroom.service.FeedbackService;
import exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeedbackController {
    @Autowired
    private FeedbackService service;
    private MultiValueMap<String, String> map;

    @PostMapping("/feedback")
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback Feedback) {

        try {
            return new ResponseEntity<Feedback>(service.createFeedback(Feedback), HttpStatus.OK);
        } catch (BusinessException e) {
            map = new LinkedMultiValueMap<>();
            map.add("message", e.getMessage());
            return new ResponseEntity<Feedback>(null, map, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/feedback/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<Feedback>(service.getFeedbackById(id), HttpStatus.OK);
        } catch (BusinessException e) {
            map = new LinkedMultiValueMap<>();
            map.add("message", e.getMessage());
            return new ResponseEntity<Feedback>(null, map, HttpStatus.NOT_FOUND);

        }

    }

    @PutMapping("/feedback")
    public ResponseEntity<Feedback> updateFeedback(@RequestBody Feedback Feedback) {
        try {
            return new ResponseEntity<Feedback>(service.updateFeedback(Feedback), HttpStatus.OK);
        } catch (BusinessException e) {
            map = new LinkedMultiValueMap<>();
            map.add("message", e.getMessage());
            return new ResponseEntity<Feedback>(null, map, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/feedback/{id}")
    public ResponseEntity<Feedback> deleteFeedback(@PathVariable("id") Long id) {
        try {
            service.deleteFeedback(id);
            return new ResponseEntity<Feedback>(HttpStatus.OK);
        } catch (BusinessException e) {
            map = new LinkedMultiValueMap<>();
            map.add("message", e.getMessage());
            return new ResponseEntity<Feedback>(null, map, HttpStatus.NOT_FOUND);

        }

    }

    @GetMapping("/feedbacks")
    public List<Feedback> getAllFeedbacks() {

        return service.getAllFeedbacks();
    }
}
