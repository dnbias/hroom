package com.dnbias.hroom.repository;

import com.dnbias.hroom.feedback.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepositoy extends JpaRepository<Feedback, Long> {
}
