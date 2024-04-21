package com.hroom.feedback.tenant.service;

import com.hroom.feedback.tenant.entity.FeedbackOfTenant;
import com.hroom.feedback.tenant.exception.BusinessException;

import java.util.List;

public interface FeedbackOfTenantService {
    public FeedbackOfTenant saveFeedback(FeedbackOfTenant feedback) throws BusinessException;

    public FeedbackOfTenant findById(Long id) throws BusinessException;

    public FeedbackOfTenant updateFeedback(FeedbackOfTenant feedback, Long feedbackId) throws BusinessException;

    public void deleteFeedbackById(Long id) throws BusinessException;

    public List<FeedbackOfTenant> fetchFeedbackList();
}
