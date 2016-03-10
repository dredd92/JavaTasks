package com.ssu.Rustam_Shekhmametyev.java.task2;

/**
 * Created by Rustam on 3/10/2016.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Menu {
    private ArrayList<FoodItem> menu = new ArrayList<FoodItem>();
    private static final int maxItemCharLength = 24;

    public Menu(String pathToMenuFile) throws IOException{
        BufferedReader input = new BufferedReader(new FileReader(pathToMenuFile));
        String temp = input.readLine();
        String[] splittedTemp = null;
        while(temp != null){
            splittedTemp = temp.split(" ");
            this.addFoodItem(new FoodItem(splittedTemp[0], Integer.parseInt(splittedTemp[1]), Integer.parseInt(splittedTemp[2])));
            temp = input.readLine();
        }
        input.close();
    }

    public static int getMaxItemCharLength() {
        return maxItemCharLength;
    }

    public void addFoodItem(FoodItem item){
        if (menu.contains(item)){
            throw new IllegalArgumentException("This item already exists in the menu");
        }
        menu.add(item);
    }

    public void removeFoodItemByName(String name){
        for (FoodItem item : menu){
            if (item.getName().equalsIgnoreCase(name)){
                menu.remove(item);
                return;
            }
        }
        throw new NoSuchElementException("Food item with this name does not exist");
    }

    public void updateFoodItemByName(String name, FoodItem updatedItem){
        for (FoodItem item : menu){
            if (item.getName().equalsIgnoreCase(name)){
                menu.set(menu.indexOf(item), updatedItem);
                return;
            }
        }
        throw new NoSuchElementException("Food item with the same name does not exist");
    }

    public FoodItem getFoodItemByName(String name){
        for (FoodItem item : menu){
            if (item.getName().equalsIgnoreCase(name)){
                return new FoodItem(item);
            }
        }
        throw new NoSuchElementException("Food item with this name does not exist");
    }

    public ArrayList<FoodItem> getMenu(){
        return new ArrayList<FoodItem>(menu);
    }
}
