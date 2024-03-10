package com.hroom.insertion.service;

import com.hroom.insertion.entity.Insertion;

import java.util.List;

public interface InsertionService {
    Insertion saveInsertion(Insertion insertion);

    List<Insertion> fetchInsertionList();

    Insertion updateInsertion(Insertion insertion, Long insertionId);

    void deleteInsertionById(Long insertionId);
}
