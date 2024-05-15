package com.hroom.user.exception;

public class MissingUserException extends BusinessException {
    public MissingUserException(String username){
        super("MissingUserException: " + username);
    }
}
