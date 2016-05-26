package com.ssu.Rustam_Shekhmametyev.java.task3.Exceptions;

/**
 * Created by John on 26/05/2016.
 */
public class OrderInvalidArgumentException extends Exception {
    private String message;
    private String argumentName;
    private String invalidValue;

    public OrderInvalidArgumentException(String message, String argumentName, String invalidValue){
        this.message = message;
        this.argumentName = argumentName;
        this.invalidValue = invalidValue;
    }

    @Override
    public String getMessage() {
        return String.format("%s. Argument: %s, Value: %s", this.message, this.argumentName, this.invalidValue);
    }
}
