package com.hroom.feedback.tenant.controller;

import com.hroom.feedback.tenant.entity.FeedbackOfTenant;
import com.hroom.feedback.tenant.service.FeedbackOfTenantService;
import com.hroom.feedback.tenant.exception.BusinessException;
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
    private FeedbackOfTenantService service;
    // TODO cambia in Stringa e basta e implementa Handler eccezioni
    private MultiValueMap<String, String> map;

    @PostMapping("/feedback/tenant")
    public ResponseEntity<FeedbackOfTenant> createFeedbackOfTenant(
                                @RequestBody FeedbackOfTenant Feedback) {

        try {
            return new ResponseEntity<FeedbackOfTenant>(
                                service.saveFeedback(Feedback), HttpStatus.OK);
        } catch (BusinessException e) {
            map = new LinkedMultiValueMap<>();
            map.add("message", e.getMessage());
            return new ResponseEntity<FeedbackOfTenant>(
                                null, map, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/feedback/tenant/{id}")
    public ResponseEntity<FeedbackOfTenant> getFeedbackOfTenantById(
                                        @PathVariable("id") Long id) {
        try {
            return new ResponseEntity<FeedbackOfTenant>(service.findById(id),
                                                        HttpStatus.OK);
        } catch (BusinessException e) {
            map = new LinkedMultiValueMap<>();
            map.add("message", e.getMessage());
            return new ResponseEntity<FeedbackOfTenant>(null, map, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/feedback/tenant")
    public ResponseEntity<FeedbackOfTenant> updateFeedback(
                                        @RequestBody FeedbackOfTenant feedback,
                                        @PathVariable("id") Long id) {
        try {
            return new ResponseEntity<FeedbackOfTenant>(service.updateFeedback(feedback, id), HttpStatus.OK);
        } catch (BusinessException e) {
            map = new LinkedMultiValueMap<>();
            map.add("message", e.getMessage());
            return new ResponseEntity<FeedbackOfTenant>(null, map, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/feedback/tenant/{id}")
    public ResponseEntity<FeedbackOfTenant> deleteFeedback(@PathVariable("id") Long id) {
        try {
            service.deleteFeedbackById(id);
            return new ResponseEntity<FeedbackOfTenant>(HttpStatus.OK);
        } catch (BusinessException e) {
            map = new LinkedMultiValueMap<>();
            map.add("message", e.getMessage());
            return new ResponseEntity<FeedbackOfTenant>(null, map, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/feedbacks/tenant")
    public List<FeedbackOfTenant> getAllFeedbacksOfTenant() {

        return service.fetchFeedbackList();
    }
}
