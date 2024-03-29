package com.userService.ExceptionHandling;

public class BadRequestException extends Exception{

    private String errorMessage;

    public BadRequestException() {}

    public BadRequestException(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
