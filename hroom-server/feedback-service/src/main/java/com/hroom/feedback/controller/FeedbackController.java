package com.hroom.feedback.controller;

import com.hroom.feedback.entity.Feedback;
import com.hroom.feedback.service.FeedbackService;
import com.hroom.feedback.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping("api/v1")
@RestController
public class FeedbackController {
    @Autowired
    private FeedbackService service;
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @PostMapping("/feedback")
    public ResponseEntity<Feedback> saveFeedback(
                                @RequestBody Feedback feedback) {
        LOGGER.info("FeedbackController > saveFeedback started");
        LOGGER.info("FeedbackController > saveFeedback > feedback: "+feedback.toString());
        Feedback fb = null;
        try {
            fb = service.saveFeedback(feedback);
            ResponseEntity.ok();
        } catch (BusinessException e) {
            LOGGER.error("FeedbackController > saveFeedback > Exception caught");
            ResponseEntity.internalServerError().body("Save Failed");
        }

        return ResponseEntity.ok(fb);
    }

    @GetMapping("/feedback")
    public List<Feedback> fetchFeedbackList() {
        LOGGER.info("FeedbackController > fetchFeedbackList started");
        LOGGER.info("FeedbackController > fetchFeedbackList");
        return service.fetchFeedbackList();
    }

    @GetMapping("/feedback/insertion/{id}")
    public List<Feedback> fetchFeedbacksOfInsertion(
                                        @PathVariable("id") Long id) {
        LOGGER.info("FeedbackController > fetchFeedbacksOfInsertion started");
        LOGGER.info("FeedbackController > fetchFeedbacksOfInsertion > id: "+id);
        LOGGER.info("FeedbackController > fetchFeedbacksOfInseriton");
        return service.fetchFeedbacksOfInsertion(id);
    }

    @GetMapping("/feedback/tenant/{id}")
    public List<Feedback> fetchFeedbacksOfTenant(
                                        @PathVariable("id") Long id) {
        LOGGER.info("FeedbackController > fetchFeedbacksOfTenant started");
        LOGGER.info("FeedbackController > fetchFeedbacksOfTenant > id: "+id);
        LOGGER.info("FeedbackController > fetchFeedbacksOfTenant");
        return service.fetchFeedbacksOfTenant(id);
    }

    @GetMapping("/feedback/{id}")
    public ResponseEntity<Feedback> getFeedbackById(
                                        @PathVariable("id") Long id) {
        LOGGER.info("FeedbackController > getFeedbackById started");
        LOGGER.info("FeedbackController > getFeedbackById > id: "+id);

        Feedback fb = null;
        try {
            fb = service.findById(id);
        } catch (BusinessException e) {
            LOGGER.error("FeedbackController > getFeedbackById > Exception caught");
            ResponseEntity.notFound();
        }
        return ResponseEntity.ok(fb);
    }

    @PutMapping("/feedback/{id}")
    public ResponseEntity<Feedback> updateFeedback(
                                        @RequestBody Feedback feedback,
                                        @PathVariable("id") Long id) {
        LOGGER.info("FeedbackController > updateFeedbackById started");
        LOGGER.info("FeedbackController > updateFeedbackById > feedback: "+feedback.toString());
        LOGGER.info("FeedbackController > updateFeedbackById > id: "+id);

        Feedback fb = null;
        try {
            fb = service.updateFeedback(feedback, id);
        } catch (BusinessException e) {
            LOGGER.error("FeedbackController > updateFeedback > Exception caught");
            ResponseEntity.notFound();
        }
        return ResponseEntity.ok(fb);
    }

    @DeleteMapping("/feedback/{id}")
    public ResponseEntity<String> deleteFeedbackById(@PathVariable("id") Long id) {
        LOGGER.info("FeedbackController > deleteFeedbackById started");
        LOGGER.info("FeedbackController > deleteFeedbackById > id: "+id);
        try {
            service.deleteFeedbackById(id);
        } catch (BusinessException e) {
            LOGGER.error("FeedbackController > deleteFeedbackById > Exception caught");
            ResponseEntity.notFound();
        }
        return ResponseEntity.ok("Deleted successfully");
    }
}
