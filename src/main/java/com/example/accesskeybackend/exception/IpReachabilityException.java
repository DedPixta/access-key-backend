package com.example.accesskeybackend.exception;

public class IpReachabilityException extends BaseException{
    public IpReachabilityException() {
    }

    public IpReachabilityException(String message) {
        super(message);
    }

    public IpReachabilityException(String message, Throwable cause) {
        super(message, cause);
    }

    public IpReachabilityException(Throwable cause) {
        super(cause);
    }

    public IpReachabilityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
