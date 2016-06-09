package com.ssu.Rustam_Shekhmametyev.java.task5.Exceptions;

/**
 * Created by John on 26/05/2016.
 */
public class MenuInvalidFormatException extends Exception{
    private String message;
    private String inputSource;
    private Exception innerException;

    @Override
    public String getMessage() {
        return String.format("Invalid input from %s", this.inputSource);
    }

    public MenuInvalidFormatException(String inputSource){
        this.message = message;
        this.inputSource = inputSource;
    }

    public MenuInvalidFormatException(Exception innerException, String inputSource){
        this.message = message;
        this.innerException = innerException;
        this.inputSource = inputSource;
    }
}
