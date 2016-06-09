package com.ssu.Rustam_Shekhmametyev.java.task5;

import com.ssu.Rustam_Shekhmametyev.java.task5.Exceptions.*;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Rustam on 3/10/2016.
 */
public class OrdersParser {
    private ArrayList<Order> orders = new ArrayList<Order>();
    private Menu menu;

    public OrdersParser(Menu menu, String pathToOrdersFile) throws IOException, OrderParserInvalidFormatException,
            OrderParserEmptyArgumentException{
        if (menu == null){
            throw new OrderParserEmptyArgumentException("Menu cannot be empty", "menu");
        }
        this.menu = menu;
        BufferedReader input = new BufferedReader(new FileReader(pathToOrdersFile));
        String temp = input.readLine();
        String clientName = null;
        this.orders = new ArrayList<>(parseOrder(pathToOrdersFile, menu));
    }

    public static ArrayList<Order> parseOrder(String pathToOrdersFile, Menu menu) throws IOException, OrderParserInvalidFormatException{
        ArrayList<Order> result = new ArrayList<>();
        BufferedReader input = new BufferedReader(new FileReader(pathToOrdersFile));
        String temp = input.readLine();
        String clientName = null;
        ArrayList<FoodItem> orderedItems = null;

        try {
            while (temp != null) {
                if (temp.contains(":")) {
                    if (orderedItems != null) {
                        result.add(new Order(clientName, orderedItems));
                    }

                    clientName = temp.substring(0, temp.length() - 1);
                    orderedItems = new ArrayList<FoodItem>();
                } else {
                    orderedItems.add(menu.getFoodItemByName(temp));
                }
                temp = input.readLine();
            }
            result.add(new Order(clientName, orderedItems));

            input.close();
            return result;
        }
        catch (MenuInvalidArgumentException | FoodItemInvalidArgumentException | OrderInvalidArgumentException e){
            throw new OrderParserInvalidFormatException(e, pathToOrdersFile);
        }
        finally {
            input.close();
        }
    }

    public String firstReport(){
        int totalPrice = 0;
        String spacesBetweenNameAndAmount = new String(new char[Menu.getMaxItemCharLength() - 4]);
        String spacesBetweenAmountAndPrice = new String(new char[Menu.getMaxItemCharLength() - 6]);
        HashMap<String, Integer> amountOfItems = new HashMap<String, Integer>();
        HashMap<String, Integer> priceOfItems = new HashMap<String, Integer>();
        String result = String.format("Name%s\tAmount%s\tPrice\n",
                spacesBetweenNameAndAmount, spacesBetweenAmountAndPrice);
        result += new String(new char[Menu.getMaxItemCharLength() * 2 + 16]).replace('\0', '-') + "\n";
        for (Order order : orders){
            ArrayList<FoodItem> foodItems = order.getOrderedItems();
            for (FoodItem item : foodItems){
                if (!amountOfItems.containsKey(item.getName())){
                    amountOfItems.put(item.getName(), 1);
                    priceOfItems.put(item.getName(), item.getPrice());
                    totalPrice += item.getPrice();
                }else{
                    amountOfItems.put(item.getName(), amountOfItems.get(item.getName()) + 1);
                    totalPrice += item.getPrice();
                }
            }
        }

        Iterator<String> itemsIterator = amountOfItems.keySet().iterator();
        int amount = 0;
        int price = 0;
        while(itemsIterator.hasNext()){
            String key = itemsIterator.next();
            spacesBetweenNameAndAmount = new String(new char[Menu.getMaxItemCharLength() - key.length()]);
            spacesBetweenAmountAndPrice = new String(new char[Menu.getMaxItemCharLength() - 3]);
            amount = amountOfItems.get(key);
            price = priceOfItems.get(key);
            result += String.format("%s\t%d%s\t\t%d\n", key + spacesBetweenNameAndAmount, amount,
                    spacesBetweenAmountAndPrice, amount * price);
            result += new String(new char[Menu.getMaxItemCharLength() * 2 + 16]).replace('\0', '-') + "\n";
        }

        result += String.format("Total price:%s\t%d", new String(new char[2 * Menu.getMaxItemCharLength() - 8]),
                totalPrice);
        return result.replace('\0', ' ');
    }

    public String secondReport(){
        String spacesBetweenNameAndOrder = new String(new char[Order.getMaxClientCharLength() - 4]);
        String spacesBetweenOrderAndPrice = new String(new char[Menu.getMaxItemCharLength() - 5]);
        String result = String.format("Name%s\tOrder%s\tPrice\n", spacesBetweenNameAndOrder,
                spacesBetweenOrderAndPrice);
        result += new String(new char[Order.getMaxClientCharLength() + Menu.getMaxItemCharLength() + 12])
                .replace('\0', '-');
        result += "\n";
        int totalPrice = 0;
        for (Order order : orders){
            spacesBetweenNameAndOrder = new String(new char[Order.getMaxClientCharLength() -
                    order.getClientName().length()]);
            result += String.format("%s%s\t", order.getClientName(), spacesBetweenNameAndOrder);
            ArrayList<FoodItem> orderedItems = order.getOrderedItems();
            spacesBetweenNameAndOrder = new String(new char[Order.getMaxClientCharLength()]);
            for (FoodItem item: orderedItems){
                result += item.getName() + "\n" + spacesBetweenNameAndOrder + "\t";
                totalPrice += item.getPrice();
            }
            result += String.format("\n%s\t\t%d\n", new String(new char[Order.getMaxClientCharLength()
                    + Menu.getMaxItemCharLength()]), totalPrice);
            result += new String(new char[Order.getMaxClientCharLength() + Menu.getMaxItemCharLength() + 12])
                    .replace('\0', '-');
            result += "\n";
            totalPrice = 0;
        }

        return result.replace('\0', ' ');
        }
    }

