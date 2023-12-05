package com.dnbias.hroom.controller;

import com.dnbias.hroom.feedback.FeedbackOfRentable;
import com.dnbias.hroom.service.FeedbackService;
import com.dnbias.hroom.service.TenantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import exception.BusinessException;

@Controller
public class TenantController {
    @Autowired
    TenantService tenantService;
    @Autowired
    FeedbackService feedbackService;

    void sendFeedback(FeedbackOfRentable feedback) throws BusinessException {
        feedbackService.createFeedback(feedback);
    }

    void deleteFeedbackById(Long feedbackId) throws BusinessException {
        feedbackService.deleteFeedback(feedbackId);
    }

    void makeReservation() {}

    void makeTransaction() {}
}
