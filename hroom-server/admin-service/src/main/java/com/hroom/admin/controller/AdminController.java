package com.hroom.admin.controller;

import com.hroom.admin.service.AdminService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping("api/v1")
@RestController
public class AdminController {
    @Autowired
    private AdminService service;
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @DeleteMapping("/delete/photo/{id}")
    public ResponseEntity<String> deletePhotoById(@PathVariable("id") Long photoId) {
        LOGGER.info("AdminController > deletePhotoById started");
        LOGGER.info("AdminController > deletePhotoById > id: "+photoId);
        return ResponseEntity.ok(service.deletePhotoById(photoId));
    }

    @DeleteMapping("/delete/insertion/{id}")
    public ResponseEntity<String> deleteInsertionById(@PathVariable("id") Long insId) {
        LOGGER.info("AdminController > deleteInsertionById started");
        LOGGER.info("AdminController > deleteInsertionById > id: "+insId);
        return ResponseEntity.ok(service.deleteInsertionById(insId));
    }

    @DeleteMapping("/ban/{id}")
    public ResponseEntity<String> banUserById(@PathVariable("id") Long userId) {
        LOGGER.info("AdminController > banUserById started");
        LOGGER.info("AdminController > banUserById > id: "+userId);
        return ResponseEntity.ok(service.banUserById(userId));
    }
}
