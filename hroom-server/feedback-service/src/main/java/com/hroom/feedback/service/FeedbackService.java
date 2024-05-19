package com.hroom.feedback.service;

import com.hroom.feedback.entity.Feedback;
import com.hroom.feedback.exception.BusinessException;

import java.util.List;

public interface FeedbackService {
    public Feedback saveFeedback(Feedback feedback) throws BusinessException;

    public Feedback findById(Long id) throws BusinessException;

    public Feedback updateFeedback(Feedback feedback, Long feedbackId) throws BusinessException;

    public void deleteFeedbackById(Long id) throws BusinessException;

    public List<Feedback> fetchFeedbackList();

    public List<Feedback> fetchFeedbacksOfTenant(Long tenantId);

    public List<Feedback> fetchFeedbacksOfInsertion(Long insertionId);
}
