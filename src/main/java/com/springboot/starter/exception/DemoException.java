package com.springboot.starter.exception;

public class DemoException extends RuntimeException {

    private static final long serialVersionUID = -4663478775990948408L;

    public DemoException() {
        super();
    }

    public DemoException(String message) {
        super(message);
    }

    public DemoException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public DemoException(Throwable throwable) {
        super(throwable);
    }
}
