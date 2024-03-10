package com.hroom.admin.exception;

import exception.BusinessException;

public class MissingUserException extends BusinessException {
    public MissingUserException(Long id){
        super("MissingUserException: " + id);
    }
}
