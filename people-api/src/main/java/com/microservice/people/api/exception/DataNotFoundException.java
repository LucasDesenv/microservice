package com.microservice.people.api.exception;

/**
 * Created by lusouza on 22/06/18.
 */
public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(String msg) {
        super(msg);
    }
}
