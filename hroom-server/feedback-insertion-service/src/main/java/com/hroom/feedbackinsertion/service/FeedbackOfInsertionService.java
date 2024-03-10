package com.hroom.feedbackinsertion.service;

import com.hroom.feedbackinsertion.entity.FeedbackOfInsertion;
import exception.BusinessException;

import java.util.List;

public interface FeedbackOfInsertionService {
    public FeedbackOfInsertion saveFeedback(FeedbackOfInsertion feedback) throws BusinessException;

    public FeedbackOfInsertion findById(Long id) throws BusinessException;

    public FeedbackOfInsertion updateFeedback(FeedbackOfInsertion feedback, Long feedbackId) throws BusinessException;

    public void deleteFeedbackById(Long id) throws BusinessException;

    public List<FeedbackOfInsertion> fetchFeedbackList();
}
