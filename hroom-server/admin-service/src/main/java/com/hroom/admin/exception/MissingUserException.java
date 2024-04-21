package com.hroom.admin.exception;

public class MissingUserException extends BusinessException {
    public MissingUserException(Long id){
        super("MissingUserException: " + id);
    }
}
