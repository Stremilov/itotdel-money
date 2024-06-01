package com.itotdel.money.exception;

public class NoDateProvidedException extends RuntimeException {
    public NoDateProvidedException() {
        super("No date provided");
    }
}
