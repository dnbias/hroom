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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping("api/v1")
@RestController
public class FeedbackController {
    @Autowired
    private FeedbackOfTenantService service;
    // TODO cambia in Stringa e basta e implementa Handler eccezioni
    private MultiValueMap<String, String> map;
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @PostMapping("/feedback/tenant")
    public ResponseEntity<FeedbackOfTenant> saveFeedback(
                                @RequestBody FeedbackOfTenant feedback) {
        LOGGER.info("FeedbackOfTenantController > saveFeedback started");
        LOGGER.info("FeedbackOfTenantController > saveFeedback > feedback: "+feedback.toString());
        try {
            return new ResponseEntity<FeedbackOfTenant>(
                                service.saveFeedback(feedback), HttpStatus.OK);
        } catch (BusinessException e) {
            map = new LinkedMultiValueMap<>();
            map.add("message", e.getMessage());
            return new ResponseEntity<FeedbackOfTenant>(
                                null, map, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/feedback/tenant")
    public List<FeedbackOfTenant> fetchFeedbackList() {
        LOGGER.info("FeedbackOfTenantController > fetchFeedbackList started");
        LOGGER.info("FeedbackOfTenantController > fetchFeedbackList");
        return service.fetchFeedbackList();
    }

    @GetMapping("/feedback/tenant/{id}")
    public ResponseEntity<FeedbackOfTenant> getFeedbackById(
                                        @PathVariable("id") Long id) {
        LOGGER.info("FeedbackOfTenantController > getFeedbackById started");
        LOGGER.info("FeedbackOfTenantController > getFeedbackById > id: "+id);
        try {
            return new ResponseEntity<FeedbackOfTenant>(service.findById(id),
                                                        HttpStatus.OK);
        } catch (BusinessException e) {
            map = new LinkedMultiValueMap<>();
            map.add("message", e.getMessage());
            return new ResponseEntity<FeedbackOfTenant>(null, map, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/feedback/tenant/{id}")
    public ResponseEntity<FeedbackOfTenant> updateFeedback(
                                        @RequestBody FeedbackOfTenant feedback,
                                        @PathVariable("id") Long id) {
        LOGGER.info("FeedbackOfTenantController > updateFeedbackById started");
        LOGGER.info("FeedbackOfTenantController > updateFeedbackById > feedback: "+feedback.toString());
        LOGGER.info("FeedbackOfTenantController > updateFeedbackById > id: "+id);
        try {
            return new ResponseEntity<FeedbackOfTenant>(service.updateFeedback(feedback, id), HttpStatus.OK);
        } catch (BusinessException e) {
            map = new LinkedMultiValueMap<>();
            map.add("message", e.getMessage());
            return new ResponseEntity<FeedbackOfTenant>(null, map, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/feedback/tenant/{id}")
    public ResponseEntity<FeedbackOfTenant> deleteFeedbackById(@PathVariable("id") Long id) {
        LOGGER.info("FeedbackOfTenantController > deleteFeedbackById started");
        LOGGER.info("FeedbackOfTenantController > deleteFeedbackById > id: "+id);
        try {
            service.deleteFeedbackById(id);
            return new ResponseEntity<FeedbackOfTenant>(HttpStatus.OK);
        } catch (BusinessException e) {
            map = new LinkedMultiValueMap<>();
            map.add("message", e.getMessage());
            return new ResponseEntity<FeedbackOfTenant>(null, map, HttpStatus.NOT_FOUND);
        }
    }
}
