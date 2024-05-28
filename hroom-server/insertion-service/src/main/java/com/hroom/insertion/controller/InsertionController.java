package com.hroom.insertion.controller;

import com.hroom.insertion.entity.Insertion;
import com.hroom.insertion.entity.Photo;
import com.hroom.insertion.service.InsertionService;
import com.hroom.insertion.service.RabbitMQInsertionService;
import com.hroom.insertion.service.RabbitMQPhotoService;
import com.hroom.insertion.exception.MissingInsertionException;
import com.hroom.insertion.exception.MissingPhotoException;

import jakarta.validation.Valid;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

@RequestMapping("api/v1")
@RestController
public class InsertionController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private InsertionService service;
    @Autowired
    private RabbitMQInsertionService insertionmq;
    @Autowired
    private RabbitMQPhotoService photomq;

    @PostMapping("/insertion")
    public Insertion saveInsertion(@Valid @RequestBody Insertion insertion) {
        LOGGER.info("InsertionController > saveInsertion started");
        LOGGER.info("InsertionController > saveInsertion > insertion: "
                    + insertion.toString());
        return service.saveInsertion(insertion);
    }

    @GetMapping("/insertion")
    public List<Insertion> fetchInsertionList() {
        LOGGER.info("InsertionController > fetchInsertionList started");
        LOGGER.info("InsertionController > fetchInsertionList");
        return service.fetchInsertionList();
    }


    @GetMapping("/insertion/{id}")
    public Insertion findInsertionById(@PathVariable Long id) {
        LOGGER.info("InsertionController > findInsertionById started");
        LOGGER.info("InsertionController > findInsertionById > id: " + id);
        try {
            return service.findById(id);
        } catch (MissingInsertionException e) {
            LOGGER.info("InsertionController > findInsertionById > MissingInsertionException caught");
            return null;
        }
    }

    @PutMapping("/insertion/{id}")
    public Insertion updateInsertion(@RequestBody Insertion insertion,
            @PathVariable("id") Long insertionId) {
        LOGGER.info("InsertionController > updateInsertionById started");
        LOGGER.info("InsertionController > updateInsertionById > user: " + insertion.toString());
        LOGGER.info("InsertionController > updateInsertionById > id: " + insertionId);
        try {
            return service.updateInsertion(insertion, insertionId);
        } catch (MissingInsertionException e) {
            LOGGER.info("InsertionController > updateInsertionById > MissingInsertionException caught");
            return null;
        }
    }

    @DeleteMapping("/insertion/{id}")
    public String deleteInsertionById(@PathVariable("id") Long insertionId) {
        LOGGER.info("InsertionController > deleteInsertionById started");
        LOGGER.info("InsertionController > deleteInsertionById > id: " + insertionId);
        service.deleteInsertionById(insertionId);
        return "Deleted Successfully";
    }

    @PutMapping(value = "/insertion/photo", consumes = {"image/jpeg", "image/png"})
    public ResponseEntity<Long> uploadPhoto(@RequestBody byte[] image) {
        LOGGER.info("InsertionController > uploadPhoto started");
        Long id = null;

        try {
            id = service.uploadPhoto(image);
        } catch (IOException e) {
            LOGGER.error("InsertionController > uploadPhoto > IOException caught");
            LOGGER.error(e.getMessage());
            ResponseEntity.internalServerError().body("Upload Failed");
        }

        return ResponseEntity.ok(id);
    }

    @GetMapping("/insertion/photo")
    public List<Long> fetchPhotoList() {
        LOGGER.info("InsertionController > fetchPhotoList started");
        LOGGER.info("InsertionController > fetchPhotoList");
        return service.fetchPhotoList();
    }

    @GetMapping("/insertion/photo/{id}")
    public ResponseEntity<byte[]> downloadPhoto(@PathVariable("id") Long photoId) {
        LOGGER.info("InsertionController > downloadPhoto started");
        LOGGER.info("InsertionController > downloadPhoto > id: " + photoId);

        byte[] data = null;

        try {
            data = service.downloadPhoto(photoId);
        } catch (MissingPhotoException e) {
            LOGGER.error("InsertionController > uploadPhoto > Exception caught");
            LOGGER.error(e.getMessage());
            ResponseEntity.internalServerError().body("Download Failed: photo not found");
        }

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(data);
    }

    @DeleteMapping("/insertion/photo/{id}")
    public ResponseEntity<String> deletePhoto(@PathVariable("id") Long photoId) {
        LOGGER.info("InsertionController > deletePhotoById started");
        LOGGER.info("InsertionController > deletePhotoById > id: " + photoId);
        service.deletePhoto(photoId);
        return ResponseEntity.ok("Deleted successfully");
    }
}
