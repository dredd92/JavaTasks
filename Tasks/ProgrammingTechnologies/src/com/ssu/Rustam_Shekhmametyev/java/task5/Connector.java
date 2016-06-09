package com.ssu.Rustam_Shekhmametyev.java.task5;

/**
 * Created by John on 09/06/2016.
 */
import java.util.*;
import java.io.*;

public class Connector {
    private File menuFile;
    private File orderFile;

    public Connector() throws IOException
    {
        menuFile = new File("\"/IO files/Task5/menu.sav\"");
        orderFile = new File("\"/IO files/Task5/order.sav\"");

        if (!menuFile.exists()){
            menuFile.createNewFile();
        }
        if (!orderFile.exists()){
            orderFile.createNewFile();
        }
    }

    public void writeToMenu(Menu menu) throws IOException{
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        try {
            fileOut = new FileOutputStream(menuFile);
            out = new ObjectOutputStream(fileOut);
            out.writeObject(menu);
        }
        finally {
            out.close();
            fileOut.close();
        }
    }

    public void writeToOrder(ArrayList<Order> order) throws IOException{
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        try {
            fileOut = new FileOutputStream(orderFile);
            out = new ObjectOutputStream(fileOut);
            out.writeObject(order);
        }
        finally {
            out.close();
            fileOut.close();
        }
    }

    public Menu readFromMenu() throws IOException, ClassNotFoundException{
        FileInputStream fileIn = null;
        ObjectInputStream in = null;
        try {
            fileIn = new FileInputStream(menuFile);
            in = new ObjectInputStream(fileIn);
            return (Menu)in.readObject();
        }
        finally {
            in.close();
            fileIn.close();
        }
    }

    public ArrayList<Order> readFromOrder() throws IOException, ClassNotFoundException{
        FileInputStream fileIn = null;
        ObjectInputStream in = null;
        try {
            fileIn = new FileInputStream(orderFile);
            in = new ObjectInputStream(fileIn);
            return (ArrayList<Order>)in.readObject();
        }
        finally {
            in.close();
            fileIn.close();
        }
    }
}
