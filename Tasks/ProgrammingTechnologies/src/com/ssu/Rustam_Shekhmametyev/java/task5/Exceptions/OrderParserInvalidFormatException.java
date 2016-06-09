package com.ssu.Rustam_Shekhmametyev.java.task5.Exceptions;

/**
 * Created by John on 26/05/2016.
 */
public class OrderParserInvalidFormatException extends Exception{
    private String inputSource;
    private Exception innerException;

    @Override
    public String getMessage() {
        return String.format("Invalid input from %s", this.inputSource);
    }

    public OrderParserInvalidFormatException(String inputSource){
        this.inputSource = inputSource;
    }

    public OrderParserInvalidFormatException( Exception innerException, String inputSource){
        this.innerException = innerException;
        this.inputSource = inputSource;
    }
}
