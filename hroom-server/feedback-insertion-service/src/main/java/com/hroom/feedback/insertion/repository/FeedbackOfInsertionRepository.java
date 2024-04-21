package com.hroom.feedback.insertion.repository;

import com.hroom.feedback.insertion.entity.FeedbackOfInsertion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackOfInsertionRepository extends JpaRepository<FeedbackOfInsertion, Long> {
}
