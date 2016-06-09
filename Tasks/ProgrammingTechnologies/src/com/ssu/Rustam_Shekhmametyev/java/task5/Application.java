package com.ssu.Rustam_Shekhmametyev.java.task5;

import com.ssu.Rustam_Shekhmametyev.java.task5.Exceptions.*;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by John on 09/06/2016.
 */
public class Application {
    public void start() throws IOException, ClassNotFoundException, FoodItemInvalidArgumentException, MenuInvalidArgumentException, MenuInvalidFormatException, OrderParserInvalidFormatException{
        String basePath = new File("").getAbsolutePath();
        String menuPath = basePath.concat("/IO files/Task2/menu.txt");
        String ordersPath = basePath.concat("/IO files/Task2/orders.txt");
        Connector con = new Connector();
        Menu testMenu = new Menu(menuPath);

        ArrayList<Order> orders = OrdersParser.parseOrder(ordersPath, testMenu);
        con.writeToMenu(testMenu);
        con.writeToOrder(orders);
        
    }
}
