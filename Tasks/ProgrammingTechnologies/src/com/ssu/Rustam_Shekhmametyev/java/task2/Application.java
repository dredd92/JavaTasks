package com.ssu.Rustam_Shekhmametyev.java.task2;

import java.io.*;

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
        Menu menu = new Menu(menuPath);
        OrdersParser orders = new OrdersParser(menu, ordersPath);
        System.out.println(orders.firstReport());


    }
}
