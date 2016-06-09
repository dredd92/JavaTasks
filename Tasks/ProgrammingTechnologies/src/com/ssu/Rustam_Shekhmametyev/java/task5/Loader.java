package com.ssu.Rustam_Shekhmametyev.java.task5;

import java.io.IOException;

import com.ssu.Rustam_Shekhmametyev.java.task5.Exceptions.*;


/**
 * Created by Rustam on 3/10/2016.
 */
public class Loader {

    public static void main(String args[]) throws IOException, MenuInvalidArgumentException,
            MenuInvalidFormatException, ClassNotFoundException, FoodItemInvalidArgumentException{
        Application myApp = new Application();
        myApp.start();

    }
}
