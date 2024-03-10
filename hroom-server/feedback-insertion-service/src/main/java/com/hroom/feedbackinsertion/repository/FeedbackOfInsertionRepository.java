package com.hroom.feedbackinsertion.repository;

import com.hroom.feedbackinsertion.entity.FeedbackOfInsertion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackOfInsertionRepository extends JpaRepository<FeedbackOfInsertion, Long> {
}
