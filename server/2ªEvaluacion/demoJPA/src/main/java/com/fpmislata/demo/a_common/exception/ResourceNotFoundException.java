package com.fpmislata.demo.a_common.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("The resource does not exist.");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}