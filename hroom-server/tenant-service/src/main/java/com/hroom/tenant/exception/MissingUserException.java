package com.hroom.tenant.exception;

public class MissingUserException extends BusinessException {
    public MissingUserException(Long id){
        super("MissingUserException: " + id);
    }
}
