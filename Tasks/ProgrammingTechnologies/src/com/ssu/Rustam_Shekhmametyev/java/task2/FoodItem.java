package com.ssu.Rustam_Shekhmametyev.java.task2;

/**
 * Created by Rustam on 3/10/2016.
 */
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        if (price <= 0){
            throw new IllegalArgumentException("Price of the item must be positive");
        }
        this.price = price;
    }

    public void setWeight(int weight) {
        if (weight <= 0){
            throw new IllegalArgumentException("Weight of the item must be positive");
        }
        this.weight = weight;
    }

    public FoodItem(String name, int weight, int price){
        this.setName(name);
        this.setWeight(weight);
        this.setPrice(price);
    }

    public FoodItem(FoodItem item){
        this.weight = item.weight;
        this.price = item.price;
        this.name = item.name;
    }

    public String toString(){
        return String.format("name: %s\nweight: %d\nprice: %d\n", name, weight, price);
    }
}
