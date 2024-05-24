package com.hroom.insertion.service;

import com.hroom.insertion.entity.Insertion;
import com.hroom.insertion.exception.MissingInsertionException;
import com.hroom.insertion.exception.MissingPhotoException;

import java.io.IOException;
import java.util.List;

public interface InsertionService {
    Insertion saveInsertion(Insertion insertion);

    List<Insertion> fetchInsertionList();

    Insertion findById(Long id)
        throws MissingInsertionException;

    Insertion updateInsertion(Insertion insertion, Long insertionId)
        throws MissingInsertionException;

    void deleteInsertionById(Long insertionId);

    Long uploadPhoto(Long roomId,byte[] image) throws IOException,MissingInsertionException ;

    byte[] downloadPhoto(Long id) throws MissingPhotoException;

    void deletePhoto(Long id);
}
