package com.hroom.feedback.insertion.controller;

import com.hroom.feedback.insertion.entity.FeedbackOfInsertion;
import com.hroom.feedback.insertion.service.FeedbackOfInsertionService;
import com.hroom.feedback.insertion.exception.BusinessException;
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
    private FeedbackOfInsertionService service;
    // TODO cambia in Stringa e basta e implementa Handler eccezioni
    private MultiValueMap<String, String> map;
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @PostMapping("/feedback/insertion")
    public ResponseEntity<FeedbackOfInsertion> saveFeedback(
                                @RequestBody FeedbackOfInsertion feedback) {
        LOGGER.info("FeedbackOfInsertionController > saveFeedback started");
        LOGGER.info("FeedbackOfInsertionController > saveFeedback > feedback: "+feedback.toString());
        try {
            return new ResponseEntity<FeedbackOfInsertion>(
                                service.saveFeedback(feedback), HttpStatus.OK);
        } catch (BusinessException e) {
            map = new LinkedMultiValueMap<>();
            map.add("message", e.getMessage());
            return new ResponseEntity<FeedbackOfInsertion>(
                                null, map, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/feedbacks/insertion")
    public List<FeedbackOfInsertion> fetchFeedbackList() {
        LOGGER.info("FeedbackOfInsertionController > fetchFeedbackList started");
        LOGGER.info("FeedbackOfInsertionController > fetchFeedbackList");
        return service.fetchFeedbackList();
    }

    @GetMapping("/feedback/insertion/{id}")
    public ResponseEntity<FeedbackOfInsertion> getFeedbackById(
                                        @PathVariable("id") Long id) {
        LOGGER.info("FeedbackOfInsertionController > getFeedbackById started");
        LOGGER.info("FeedbackOfInsertionController > getFeedbackById > id: "+id);
        try {
            return new ResponseEntity<FeedbackOfInsertion>(service.findById(id),
                                                        HttpStatus.OK);
        } catch (BusinessException e) {
            map = new LinkedMultiValueMap<>();
            map.add("message", e.getMessage());
            return new ResponseEntity<FeedbackOfInsertion>(null, map, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/feedback/insertion/{id}")
    public ResponseEntity<FeedbackOfInsertion> updateFeedback(
                                        @RequestBody FeedbackOfInsertion feedback,
                                        @PathVariable("id") Long id) {
        LOGGER.info("FeedbackOfInsertionController > updateFeedbackById started");
        LOGGER.info("FeedbackOfInsertionController > updateFeedbackById > feedback: "+feedback.toString());
        LOGGER.info("FeedbackOfInsertionController > updateFeedbackById > id: "+id);
        try {
            return new ResponseEntity<FeedbackOfInsertion>(service.updateFeedback(feedback, id), HttpStatus.OK);
        } catch (BusinessException e) {
            map = new LinkedMultiValueMap<>();
            map.add("message", e.getMessage());
            return new ResponseEntity<FeedbackOfInsertion>(null, map, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/feedback/insertion/{id}")
    public ResponseEntity<FeedbackOfInsertion> deleteFeedback(@PathVariable("id") Long id) {
        LOGGER.info("FeedbackOfInsertionController > deleteFeedbackById started");
        LOGGER.info("FeedbackOfInsertionController > deleteFeedbackById > id: "+id);
        try {
            service.deleteFeedbackById(id);
            return new ResponseEntity<FeedbackOfInsertion>(HttpStatus.OK);
        } catch (BusinessException e) {
            map = new LinkedMultiValueMap<>();
            map.add("message", e.getMessage());
            return new ResponseEntity<FeedbackOfInsertion>(null, map, HttpStatus.NOT_FOUND);
        }
    }

}
