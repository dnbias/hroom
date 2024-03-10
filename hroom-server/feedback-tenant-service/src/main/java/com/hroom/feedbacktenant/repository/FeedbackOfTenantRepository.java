package com.hroom.feedbacktenant.repository;

import com.hroom.feedbacktenant.entity.FeedbackOfTenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackOfTenantRepository extends JpaRepository<FeedbackOfTenant, Long> {
}
