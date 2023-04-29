package com.goit.reading;

public class ResourceReadException extends RuntimeException {
    public ResourceReadException() {
    }

    public ResourceReadException(String message) {
        super(message);
    }

    public ResourceReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
