package com.dnbias.hroom.repository;

import com.dnbias.hroom.feedback.FeedbackOfInsertion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackOfInsertionRepository extends JpaRepository<FeedbackOfInsertion, Long> {
}
