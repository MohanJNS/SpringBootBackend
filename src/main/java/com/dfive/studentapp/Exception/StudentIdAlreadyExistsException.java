package com.dfive.studentapp.Exception;

public class StudentIdAlreadyExistsException extends RuntimeException {

    public StudentIdAlreadyExistsException() {
        super("user i exist");
    }
}