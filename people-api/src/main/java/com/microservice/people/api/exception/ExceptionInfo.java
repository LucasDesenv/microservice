package com.microservice.people.api.exception;

/**
 * Created by lusouza on 21/06/18.
 */
public class ExceptionInfo {
    private final String title;
    private final String message;

    public ExceptionInfo(final String message) {
        this.message = message;
        this.title = "";
    }

    public ExceptionInfo(final String message, final String title) {
        this.message = message;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

}
