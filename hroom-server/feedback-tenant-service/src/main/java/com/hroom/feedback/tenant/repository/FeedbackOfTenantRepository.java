package com.hroom.feedback.tenant.repository;

import com.hroom.feedback.tenant.entity.FeedbackOfTenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackOfTenantRepository extends JpaRepository<FeedbackOfTenant, Long> {
}
