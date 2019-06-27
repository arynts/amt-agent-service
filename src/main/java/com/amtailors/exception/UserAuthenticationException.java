package com.amtailors.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UserAuthenticationException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public UserAuthenticationException(String message){
        super(message);
    }
}
