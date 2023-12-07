package com.dnbias.hroom.service;

import com.dnbias.hroom.feedback.Feedback;
import exception.BusinessException;

import java.util.List;

public interface FeedbackService {
    public Feedback createFeedback(Feedback Feedback) throws BusinessException;

    public Feedback getFeedbackById(Long id) throws BusinessException;

    public Feedback updateFeedback(Feedback Feedback) throws BusinessException;

    public void deleteFeedback(Long id) throws BusinessException;

    public List<Feedback> getAllFeedbacks();
}
