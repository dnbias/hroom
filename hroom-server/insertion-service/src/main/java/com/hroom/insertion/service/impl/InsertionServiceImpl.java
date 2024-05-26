package com.hroom.insertion.service.impl;

import com.hroom.insertion.service.InsertionService;
import com.hroom.insertion.repository.InsertionRepository;
import com.hroom.insertion.repository.PhotoRepository;
import com.hroom.insertion.entity.Insertion;
import com.hroom.insertion.entity.Photo;
import com.hroom.insertion.exception.MissingInsertionException;
import com.hroom.insertion.exception.MissingPhotoException;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.hroom.insertion.security.SecurityTools.isSanitized;

@Service
public class InsertionServiceImpl implements InsertionService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private InsertionRepository insertionRepository;
    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public Insertion saveInsertion(Insertion insertion) {
        LOGGER.info("InsertionServiceImpl > saveInsertion started");
        return insertionRepository.save(insertion);
    }

    @Override
    public List<Insertion> fetchInsertionList() {
        LOGGER.info("InsertionServiceImpl > fetchInsertionList started");
        return (List<Insertion>)  insertionRepository.findAll();
    }

    @Override
    public Insertion findById(Long id) throws MissingInsertionException {
        LOGGER.info("InsertionServiceImpl > findById started");
        Optional<Insertion> optional = insertionRepository.findById(id);
        if (optional.isEmpty()) {
            throw new MissingInsertionException(id);
        }
        return optional.get();
    }

    @Override
    public Insertion updateInsertion(Insertion insertion, Long insertionId)
        throws MissingInsertionException {

        LOGGER.info("InsertionServiceImpl > updateInsertion started");

        Optional<Insertion> optional = insertionRepository.findById(insertionId);
        if (optional.isEmpty()) {
            throw new MissingInsertionException(insertionId);
        }
        Insertion insertionDB = optional.get();

        if (isSanitized(insertion.getName())) insertionDB.setName(insertion.getName());
        if (isSanitized(insertion.getFeatures())) insertionDB.setFeatures(insertion.getFeatures());
        if (isSanitized(insertion.getDescription())) insertionDB.setDescription(
                                                        insertion.getDescription());
        if (isSanitized(insertion.getPrice())) insertionDB.setPrice(insertion.getPrice());
        if (isSanitized(insertion.getPhotoIds())) insertionDB.setPhotoIds(insertion.getPhotoIds());
        if (isSanitized(insertion.getReceivedFeedbacksIds()))
            insertionDB.setReceivedFeedbacksIds(insertion.getReceivedFeedbacksIds());
        if (isSanitized(insertion.getAvailabilityId()))
            insertionDB.setAvailabilityId(insertion.getAvailabilityId());

        return insertionRepository.save(insertionDB);
    }

    @Override
    public void deleteInsertionById(Long insertionId) {
        LOGGER.info("InsertionServiceImpl > deleteInsertionById started");
        insertionRepository.deleteById(insertionId);
    }

    @Override
    public List<Long> fetchPhotoList() {
        LOGGER.info("InsertionServiceImpl > fetchPhotoList started");
        Iterable<Photo> list = photoRepository.findAll();
        List<Long> ids = new ArrayList<>();
        for (Photo i : list)
            ids.add(i.getId());
        return ids;
    }

    @Override
    public Long uploadPhoto(byte[] data) throws IOException {
        LOGGER.info("InsertionServiceImpl > uploadPhoto started");

        Photo photo = new Photo();
        photo.setData(data);

        Photo savedObj = photoRepository.save(photo);
        Long id = savedObj.getId();

        LOGGER.info("InsertionServiceImpl > uploadPhoto > file written to DB");
        LOGGER.info("InsertionServiceImpl > uploadPhoto > id: " + id);

        return id;
    }

    @Override
    public byte[] downloadPhoto(Long id) throws MissingPhotoException {
        LOGGER.info("InsertionServiceImpl > downloadPhoto started");

        Optional<Photo> optional = photoRepository.findById(id);
        if (optional.isEmpty()) {
            throw new MissingPhotoException(id);
        }
        LOGGER.info("InsertionServiceImpl > downloadPhoto > file found");
        return optional.get().getData();
    }

    @Override
    public void deletePhoto(Long id) {
        photoRepository.deleteById(id);
    }
}
