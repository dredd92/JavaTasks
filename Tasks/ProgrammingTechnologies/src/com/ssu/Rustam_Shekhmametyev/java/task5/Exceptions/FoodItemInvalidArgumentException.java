package com.ssu.Rustam_Shekhmametyev.java.task5.Exceptions;

/**
 * Created by John on 26/05/2016.
 */
public class FoodItemInvalidArgumentException extends Exception {
    private String message;
    private String argumentName;
    private String invalidValue;
    private final String DefaultMessage = "Illegal argument is used in one of the food item methods";

    @Override
    public String getMessage() {
        return String.format("%s. Argument: %s, Value: %s", this.message, this.argumentName, this.invalidValue);
    }

    public FoodItemInvalidArgumentException(String message, String argumentName, String invalidValue){
        this.message = message;
        this.argumentName = argumentName;
        this.invalidValue = invalidValue;
    }

    public FoodItemInvalidArgumentException(){
        this.message = this.DefaultMessage;
    }
}
