package com.hroom.feedback.insertion.service;

import com.hroom.feedback.insertion.entity.FeedbackOfInsertion;
import com.hroom.feedback.insertion.exception.BusinessException;

import java.util.List;

public interface FeedbackOfInsertionService {
    public FeedbackOfInsertion saveFeedback(FeedbackOfInsertion feedback) throws BusinessException;

    public FeedbackOfInsertion findById(Long id) throws BusinessException;

    public FeedbackOfInsertion updateFeedback(FeedbackOfInsertion feedback, Long feedbackId) throws BusinessException;

    public void deleteFeedbackById(Long id) throws BusinessException;

    public List<FeedbackOfInsertion> fetchFeedbackList();
}
