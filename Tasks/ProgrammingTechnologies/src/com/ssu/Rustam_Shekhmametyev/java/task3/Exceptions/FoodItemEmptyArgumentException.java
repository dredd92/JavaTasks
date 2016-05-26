package com.ssu.Rustam_Shekhmametyev.java.task3.Exceptions;

/**
 * Created by John on 26/05/2016.
 */
public class FoodItemEmptyArgumentException extends FoodItemInvalidArgumentException {

    public FoodItemEmptyArgumentException(String message, String argument){
        super(message, argument, "null");
    }
}
