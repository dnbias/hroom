package com.dnbias.hroom.service;

import com.dnbias.hroom.feedback.Feedback;
import com.dnbias.hroom.repository.FeedbackRepositoy;
import com.dnbias.hroom.repository.UserRepository;
import exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FeedbackServiceImpl implements FeedbackService{


    @Autowired
    private FeedbackRepositoy repository;
    private boolean isValidRating(int rating) {
        if (rating  < 0 || rating > 10) {
            return false;
        }
        return true;
    }
    @Override
    public Feedback createFeedback(Feedback feedback) throws BusinessException {

        if (!isValidRating(feedback.getRating())) {
            throw new BusinessException("rating should be between 0 and 10");
        }
        return repository.save(feedback);
    }

    @Override
    public Feedback getFeedbackById(Long id) throws BusinessException {
        if (id < 0) {
            throw new BusinessException("id cannot be" + id);
        }
        Feedback feedback = null;
        try {
            feedback = repository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new BusinessException("No feedback found for id " + id);
        }
        return feedback;

    }

    @Override
    public Feedback updateFeedback(Feedback feedback) throws BusinessException {
        if (!isValidRating(feedback.getRating())) {
            throw new BusinessException("rating should be between 0 and 10");
        }

        if (feedback.getId() < 0) {
            throw new BusinessException("id cannot be " + feedback.getId());
        }
        try {
            repository.findById(feedback.getId()).get();
        } catch (NoSuchElementException e) {
            throw new BusinessException("No feedback found for id " + feedback.getId());
        }
        return repository.save(feedback);

    }

    @Override
    public void deleteFeedback(Long id) throws BusinessException {
        if (id < 0) {
            throw new BusinessException("id cannot be" + id);
        }
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new BusinessException("No feedback found for id " + id);
        }

    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return repository.findAll();

    }
}
