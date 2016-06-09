package com.ssu.Rustam_Shekhmametyev.java.task5;



/**
 * Created by Rustam on 3/10/2016.
 */
import com.ssu.Rustam_Shekhmametyev.java.task5.Exceptions.*;

public class FoodItem {
    private String name;
    private int weight;
    private int price;

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws FoodItemInvalidArgumentException {
        if (name == null || name.trim().isEmpty()){
            throw new FoodItemEmptyArgumentException("Name of a food item cannot be empty", "name");
        }
        this.name = name;
    }

    public void setPrice(int price) throws FoodItemInvalidArgumentException {
        if (price <= 0){
            throw new FoodItemInvalidArgumentException("Price of the item must be positive", "price", Integer.toString(price));
        }
        this.price = price;
    }

    public void setWeight(int weight) throws FoodItemInvalidArgumentException {
        if (weight <= 0){
            throw new FoodItemInvalidArgumentException("Weight of the item must be positive", "weight", Integer.toString(weight));
        }
        this.weight = weight;
    }

    public FoodItem(String name, int weight, int price) throws FoodItemInvalidArgumentException {
        this.setName(name);
        this.setWeight(weight);
        this.setPrice(price);
    }

    public FoodItem(FoodItem item) throws FoodItemInvalidArgumentException {
        if (item == null){
            throw new FoodItemEmptyArgumentException("Copied food item cannot be null", "item");
        }
        this.weight = item.weight;
        this.price = item.price;
        this.name = item.name;
    }

    public String toString(){
        return String.format("name: %s\nweight: %d\nprice: %d\n", name, weight, price);
    }
}
