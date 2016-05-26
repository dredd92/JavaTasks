package com.ssu.Rustam_Shekhmametyev.java.task3;

/**
 * Created by Rustam on 3/10/2016.
 */
import com.ssu.Rustam_Shekhmametyev.java.task3.Exceptions.FoodItemInvalidArgumentException;
import com.ssu.Rustam_Shekhmametyev.java.task3.Exceptions.MenuEmptyArgumentException;
import com.ssu.Rustam_Shekhmametyev.java.task3.Exceptions.MenuInvalidArgumentException;
import com.ssu.Rustam_Shekhmametyev.java.task3.Exceptions.MenuInvalidFormatException;
import com.sun.javaws.exceptions.InvalidArgumentException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Menu {
    private ArrayList<FoodItem> menu = new ArrayList<FoodItem>();
    private static final int maxItemCharLength = 24;

    public Menu(String pathToMenuFile) throws IOException, MenuInvalidFormatException, MenuInvalidArgumentException{
        BufferedReader input = new BufferedReader(new FileReader(pathToMenuFile));
        String temp = input.readLine();
        String[] splittedTemp = null;
        while(temp != null){
            splittedTemp = temp.split(" ");
            try {
                this.addFoodItem(new FoodItem(splittedTemp[0], Integer.parseInt(splittedTemp[1]), Integer.parseInt(splittedTemp[2])));
            }
            catch (FoodItemInvalidArgumentException e){
                throw new MenuInvalidFormatException(e, pathToMenuFile);
            }
            temp = input.readLine();
        }
        input.close();
    }

    public static int getMaxItemCharLength() {
        return maxItemCharLength;
    }

    public void addFoodItem(FoodItem item) throws  MenuInvalidArgumentException {
        if (item == null){
            throw new MenuEmptyArgumentException("Cannot add null", "item");
        }
        if (!menu.contains(item)){
            menu.add(item);
        }

    }

    public void removeFoodItemByName(String name) throws MenuInvalidArgumentException{
        if (name == null){
            throw new MenuEmptyArgumentException("Cannot remove an item without name", "name");
        }
        for (FoodItem item : menu){
            if (item.getName().equalsIgnoreCase(name)){
                menu.remove(item);
                return;
            }
        }
        throw new MenuInvalidArgumentException("Food item with this name does not exist", "name", name);
    }

    public void updateFoodItemByName(String name, FoodItem updatedItem) throws MenuInvalidArgumentException{
        for (FoodItem item : menu){
            if (item.getName().equalsIgnoreCase(name)){
                menu.set(menu.indexOf(item), updatedItem);
                return;
            }
        }
        throw new MenuInvalidArgumentException("Food item with the same name does not exist", "name", name);
    }

    public FoodItem getFoodItemByName(String name) throws MenuInvalidArgumentException, FoodItemInvalidArgumentException {
        for (FoodItem item : menu){
            if (item.getName().equalsIgnoreCase(name)){
                return new FoodItem(item);
            }
        }
        throw new MenuInvalidArgumentException("Food item with this name does not exist", "name", name);
    }

    public ArrayList<FoodItem> getMenu(){
        return new ArrayList<FoodItem>(menu);
    }
}
