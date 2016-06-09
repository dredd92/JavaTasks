package com.ssu.Rustam_Shekhmametyev.java.task5.Exceptions;

/**
 * Created by John on 26/05/2016.
 */
public class MenuInvalidArgumentException extends Exception{
    private String message;
    private String argumentName;
    private String invalidValue;

    public MenuInvalidArgumentException(String message, String argumentName, String invalidValue){
        this.message = message;
        this.argumentName = argumentName;
        this.invalidValue = invalidValue;
    }

    @Override
    public String getMessage() {
        return String.format("%s. Argument: %s, Value: %s", this.message, this.argumentName, this.invalidValue);
    }
}
