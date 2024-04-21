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

@RestController
public class FeedbackController {
    @Autowired
    private FeedbackOfInsertionService service;
    // TODO cambia in Stringa e basta e implementa Handler eccezioni
    private MultiValueMap<String, String> map;

    @PostMapping("/feedback/insertion")
    public ResponseEntity<FeedbackOfInsertion> createFeedbackOfInsertion(
                                @RequestBody FeedbackOfInsertion Feedback) {

        try {
            return new ResponseEntity<FeedbackOfInsertion>(
                                service.saveFeedback(Feedback), HttpStatus.OK);
        } catch (BusinessException e) {
            map = new LinkedMultiValueMap<>();
            map.add("message", e.getMessage());
            return new ResponseEntity<FeedbackOfInsertion>(
                                null, map, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/feedback/insertion/{id}")
    public ResponseEntity<FeedbackOfInsertion> getFeedbackOfInsertionById(
                                        @PathVariable("id") Long id) {
        try {
            return new ResponseEntity<FeedbackOfInsertion>(service.findById(id),
                                                        HttpStatus.OK);
        } catch (BusinessException e) {
            map = new LinkedMultiValueMap<>();
            map.add("message", e.getMessage());
            return new ResponseEntity<FeedbackOfInsertion>(null, map, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/feedback/insertion")
    public ResponseEntity<FeedbackOfInsertion> updateFeedback(
                                        @RequestBody FeedbackOfInsertion feedback,
                                        @PathVariable("id") Long id) {
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
        try {
            service.deleteFeedbackById(id);
            return new ResponseEntity<FeedbackOfInsertion>(HttpStatus.OK);
        } catch (BusinessException e) {
            map = new LinkedMultiValueMap<>();
            map.add("message", e.getMessage());
            return new ResponseEntity<FeedbackOfInsertion>(null, map, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/feedbacks/insertion")
    public List<FeedbackOfInsertion> getAllFeedbacksOfInsertion() {

        return service.fetchFeedbackList();
    }
}
