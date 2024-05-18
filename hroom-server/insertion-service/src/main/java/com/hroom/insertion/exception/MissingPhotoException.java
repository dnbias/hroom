package com.hroom.insertion.exception;

public class MissingPhotoException extends BusinessException {
    public MissingPhotoException(Long id){
        super("MissingPhotoException: " + id);
    }
}
