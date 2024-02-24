package com.categoryproductService.ExceptionHandling;

public class EntityNotFoundException extends Exception{

    private String errorMessage;

    public EntityNotFoundException(){}

    public EntityNotFoundException(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return this.errorMessage;
    }
}
