package com.dnbias.hroom.controller;

import com.dnbias.hroom.feedback.FeedbackOfInsertion;
import com.dnbias.hroom.service.FeedbackOfInsertionService;
import com.dnbias.hroom.service.TenantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import exception.BusinessException;

@Controller
public class TenantController {
    @Autowired
    TenantService tenantService;
    // @Autowired
    // FeedbackOfInsertionService feedbackService;

    void sendFeedback(FeedbackOfInsertion feedback) throws BusinessException {
        // feedbackService.saveFeedback(feedback);
    }

    void deleteFeedbackById(Long feedbackId) throws BusinessException {
        // feedbackService.deleteFeedbackById(feedbackId);
    }

    void makeReservation() {}

    void makeTransaction() {}
}
