package com.hroom.feedback.repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

import com.hroom.feedback.entity.Feedback;
import com.hroom.feedback.entity.FeedbackOfInsertion;
import com.hroom.feedback.entity.FeedbackOfTenant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
    List<Feedback> findByTenantId(Long id);
    List<Feedback> findByInsertionId(Long id);
}
