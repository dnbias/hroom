package com.dnbias.hroom.repository;

import com.dnbias.hroom.feedback.FeedbackOfTenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackOfTenantRepository extends JpaRepository<FeedbackOfTenant, Long> {
}
