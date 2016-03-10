package com.ssu.Rustam_Shekhmametyev.java.task2;

/**
 * Created by Rustam on 3/10/2016.
 */
import java.util.ArrayList;

public class Order {
    String clientName;
    ArrayList<FoodItem> orderedItems;

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public ArrayList<FoodItem> getOrderedItems() {
        return new ArrayList<FoodItem>(orderedItems);
    }
}
