package com.ssu.Rustam_Shekhmametyev.java.task5;

/**
 * Created by Rustam on 3/10/2016.
 */
import com.ssu.Rustam_Shekhmametyev.java.task5.Exceptions.*;


import java.util.ArrayList;

public class Order {
    private String clientName;
    private ArrayList<FoodItem> orderedItems = new ArrayList<FoodItem>();
    private final static int maxClientCharLength = 24;

    public Order(String clientName, ArrayList<FoodItem> orderedItems) throws OrderInvalidArgumentException{
        if (clientName == null || clientName.trim().isEmpty()){
            throw new OrderEmptyArgumentException("Client's name cannot be empty", "clientName");
        }
        else if (orderedItems == null || orderedItems.size() == 0){
            throw new OrderEmptyArgumentException("List of ordered items cannot be empty", "orderedItems");
        }
        this.clientName = clientName;
        this.orderedItems = new ArrayList<FoodItem>(orderedItems);
    }


    public Order(String clientName) throws OrderInvalidArgumentException{
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

    public void setClientName(String clientName) throws OrderInvalidArgumentException{
        if (clientName.length() > 24){
            throw new OrderInvalidArgumentException(String.format("Names can't be longer than %d",
                    maxClientCharLength),
                    "clientName", clientName);
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
