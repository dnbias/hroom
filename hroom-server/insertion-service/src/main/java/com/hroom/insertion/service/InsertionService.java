package com.hroom.insertion.service;

import com.hroom.insertion.entity.Insertion;
import com.hroom.insertion.exception.MissingInsertionException;

import java.util.List;

public interface InsertionService {
    Insertion saveInsertion(Insertion insertion);

    List<Insertion> fetchInsertionList();

    Insertion findById(Long id)
        throws MissingInsertionException;

    Insertion updateInsertion(Insertion insertion, Long insertionId)
        throws MissingInsertionException;

    void deleteInsertionById(Long insertionId);
}
