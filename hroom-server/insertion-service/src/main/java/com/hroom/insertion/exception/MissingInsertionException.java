package com.hroom.insertion.exception;

public class MissingInsertionException extends BusinessException {
    public MissingInsertionException(Long id){
        super("MissingInsertionException: " + id);
    }
}
