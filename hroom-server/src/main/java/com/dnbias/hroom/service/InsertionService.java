package com.dnbias.hroom.service;

import com.dnbias.hroom.room.Insertion;

import java.util.List;

public interface InsertionService {
    Insertion saveInsertion(Insertion insertion);

    List<Insertion> fetchInsertionList();

    Insertion updateInsertion(Insertion insertion, Long insertionId);

    void deleteInsertionById(Long insertionId);
}
