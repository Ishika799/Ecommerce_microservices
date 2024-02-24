package com.userService.ExceptionHandling;

public class UserException extends Exception{

    private String errorMessage;

    public UserException(){}

    public UserException(String errorMessage){
        super();
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return this.errorMessage;
    }
}
