package com.ssu.Rustam_Shekhmametyev.java.task3;

import com.ssu.Rustam_Shekhmametyev.java.task3.Exceptions.MenuInvalidArgumentException;
import com.ssu.Rustam_Shekhmametyev.java.task3.Exceptions.MenuInvalidFormatException;
import com.ssu.Rustam_Shekhmametyev.java.task3.Exceptions.OrderParserInvalidArgumentException;
import com.ssu.Rustam_Shekhmametyev.java.task3.Exceptions.OrderParserInvalidFormatException;

import java.io.File;
import java.io.IOException;

/**
 * Created by Rustam on 3/10/2016.
 */
public class Application {
    public void start() throws IOException{
        String basePath = new File("").getAbsolutePath();
        String menuPath = basePath.concat("/IO files/Task2/menu.txt");
        String ordersPath = basePath.concat("/IO files/Task2/orders.txt");
        File menuFile = new File(menuPath);
        File ordersFile = new File(ordersPath);
        ordersFile.createNewFile();
        try {
            Menu menu = new Menu(menuPath);
        }
        catch (MenuInvalidFormatException | MenuInvalidArgumentException e){
            System.out.println(e.getMessage());
        }
        try {
            OrdersParser orders = new OrdersParser(null, ordersPath);
            System.out.println(orders.firstReport());
        }
        catch (OrderParserInvalidFormatException | OrderParserInvalidArgumentException e){
            System.out.println(e.getMessage());
        }



    }
}
