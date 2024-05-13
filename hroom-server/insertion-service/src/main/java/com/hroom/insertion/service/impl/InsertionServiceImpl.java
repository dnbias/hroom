package com.hroom.insertion.service.impl;

import com.hroom.insertion.service.InsertionService;
import com.hroom.insertion.repository.InsertionRepository;
import com.hroom.insertion.entity.Insertion;
import com.hroom.insertion.exception.MissingInsertionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.hroom.insertion.security.SecurityTools.isSanitized;

@Service
public class InsertionServiceImpl implements InsertionService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private InsertionRepository repository;

    @Override
    public Insertion saveInsertion(Insertion insertion) {
        LOGGER.info("InsertionServiceImpl > saveInsertion started");
        return repository.save(insertion);
    }

    @Override
    public List<Insertion> fetchInsertionList() {
        LOGGER.info("InsertionServiceImpl > fetchInsertionList started");
        return (List<Insertion>)  repository.findAll();
    }

    @Override
    public Insertion findById(Long id) throws MissingInsertionException {
        LOGGER.info("InsertionServiceImpl > findById started");
        Optional<Insertion> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new MissingInsertionException(id);
        }
        return optional.get();
    }

    @Override
    public Insertion updateInsertion(Insertion insertion, Long insertionId)
        throws MissingInsertionException {

        LOGGER.info("InsertionServiceImpl > updateInsertion started");

        Optional<Insertion> optional = repository.findById(insertionId);
        if (optional.isEmpty()) {
            throw new MissingInsertionException(insertionId);
        }
        Insertion insertionDB = optional.get();

        if (isSanitized(insertion.getName())) insertionDB.setName(insertion.getName());
        if (isSanitized(insertion.getFeatures())) insertionDB.setFeatures(insertion.getFeatures());
        if (isSanitized(insertion.getDescription())) insertionDB.setDescription(
                                                        insertion.getDescription());
        if (isSanitized(insertion.getPrice())) insertionDB.setPrice(insertion.getPrice());
        if (isSanitized(insertion.getPhotoUrl())) insertionDB.setPhotoUrl(insertion.getPhotoUrl());
        if (isSanitized(insertion.getReceivedFeedbacksIds()))
            insertionDB.setReceivedFeedbacksIds(insertion.getReceivedFeedbacksIds());
        if (isSanitized(insertion.getAvailabilityId()))
            insertionDB.setAvailabilityId(insertion.getAvailabilityId());

        return repository.save(insertionDB);
    }

    @Override
    public void deleteInsertionById(Long insertionId) {
        LOGGER.info("InsertionServiceImpl > deleteInsertionById started");
        repository.deleteById(insertionId);
    }
}
