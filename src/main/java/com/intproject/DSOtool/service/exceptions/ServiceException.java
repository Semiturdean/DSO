package com.intproject.DSOtool.service.exceptions;

public class ServiceException extends RuntimeException {

    public ServiceException(){super();}

    public ServiceException(String message) {
        super(message);
    }
}
