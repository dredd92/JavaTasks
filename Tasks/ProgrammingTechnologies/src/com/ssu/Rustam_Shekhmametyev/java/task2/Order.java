package com.ssu.Rustam_Shekhmametyev.java.task2;

/**
 * Created by Rustam on 3/10/2016.
 */
import java.util.ArrayList;

public class Order {
    private String clientName;
    private ArrayList<FoodItem> orderedItems = new ArrayList<FoodItem>();
    private final static int maxClientCharLength = 24;

    public Order(String clientName, ArrayList<FoodItem> orderedItems){
        this.clientName = clientName;
        this.orderedItems = new ArrayList<FoodItem>(orderedItems);
    }


    public Order(String clientName){
        this.setClientName(clientName);
    }

    public void addFoodItem(FoodItem item){
        orderedItems.add(item);
    }

    public String getClientName() {
        return clientName;
    }

    public static int getMaxClientCharLength() {
        return maxClientCharLength;
    }

    public void setClientName(String clientName) {
        if (clientName.length() > 24){
            throw new IllegalArgumentException(String.format("Names can't be longer than %d", maxClientCharLength));
        }
        this.clientName = clientName;
    }

    public ArrayList<FoodItem> getOrderedItems() {
        return new ArrayList<FoodItem>(orderedItems);
    }

    public int calculateTotalOrderPrice(){
        int result = 0;
        for (FoodItem item : orderedItems){
            result += item.getPrice();
        }
        return result;
    }
}
