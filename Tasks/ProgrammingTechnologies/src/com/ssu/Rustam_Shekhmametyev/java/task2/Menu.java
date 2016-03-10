package com.ssu.Rustam_Shekhmametyev.java.task2;

/**
 * Created by Rustam on 3/10/2016.
 */
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Menu {
    ArrayList<FoodItem> menu = new ArrayList<FoodItem>();

    public void addFoodItem(FoodItem item){
        if (menu.contains(item)){
            throw new IllegalArgumentException("This item already exists in the menu");
        }
        menu.add(item);
    }

    public void removeFoodItem(FoodItem item){
        if (!menu.contains(item)){
            throw new NoSuchElementException("This item does not exist in the menu");
        }
        menu.remove(item);
    }

    public FoodItem getFoodItemByName(String name){
        for (FoodItem item : menu){
            if (item.getName().equalsIgnoreCase(name)){
                return new FoodItem(item);
            }
        }
        throw new NoSuchElementException("Food item with the same name does not exist");
    }

    public ArrayList<FoodItem> getMenu(){
        return new ArrayList<FoodItem>(menu);
    }
}
