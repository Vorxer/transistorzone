package com.transistorzone.blog.exceptions;

public class BlogServiceException extends Exception{
    public BlogServiceException() {
    }

    public BlogServiceException(String message) {
        super(message);
    }

    public BlogServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlogServiceException(Throwable cause) {
        super(cause);
    }

    public BlogServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
