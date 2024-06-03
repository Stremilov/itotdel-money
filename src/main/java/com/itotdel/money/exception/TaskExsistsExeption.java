package com.itotdel.money.exception;

public class TaskExsistsExeption extends RuntimeException {
    public TaskExsistsExeption() {
        super("User already exists");
    }
}
