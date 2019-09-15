package com.github.seraphain.pogen.service;

@SuppressWarnings("serial")
public class PogenServiceException extends RuntimeException {

    public PogenServiceException() {
        super();
    }

    public PogenServiceException(String message) {
        super(message);
    }

    public PogenServiceException(Throwable cause) {
        super(cause);
    }

    public PogenServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PogenServiceException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
