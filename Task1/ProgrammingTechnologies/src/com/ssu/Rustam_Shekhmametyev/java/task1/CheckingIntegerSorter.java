package com.ssu.Rustam_Shekhmametyev.java.task1;

import java.util.*;
/**
 * Created by Rustam on 3/1/2016.
 */
public class CheckingIntegerSorter {

    static Random randGenerator = new Random();

    private void setRandom(int[] array){
        for(int i = 0; i < array.length; i++){
            array[i] = randGenerator.nextInt(array.length);
        }
    }

    private boolean checkIfSorted(int[] array){
        for(int i = 0; i < array.length - 2; i++){
            if(array[i + 1] < array[i]){
                return false;
            }
        }
        return true;
    }

    private void start() throws InterruptedException{
        Scanner input = new Scanner(System.in);
        int startNumberOfThreads = Thread.activeCount();
        System.out.println("Number of threads active: " + startNumberOfThreads);
        System.out.print("Enter the size of the array to be sorted: ");
        int size = input.nextInt();
        if(size < 0){
            throw new IllegalArgumentException("The size of the array must be a positive integer");
        }
        int[] array = new int[size];
        setRandom(array);
        System.out.println("Unsorted array: ");
        print(array);
        double startTime = System.currentTimeMillis();
        IntegerSorter.quicksort(array);
        while(Thread.activeCount() != startNumberOfThreads){
        }
        System.out.println("Working time (in seconds): " + (System.currentTimeMillis() - startTime) / 1000);
        System.out.println("Sorted array: ");
        print(array);

        if(checkIfSorted(array)){
            System.out.println("The array is sorted");
        } else{
            System.out.println("The array is not sorted. An error in the sorting algorithm occurred.");
        }
    }

    private void print(int[] array){
        if(array.length > 46000){
            System.out.println("Length of the array is too great to display here");
            return;
        }
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws InterruptedException{
        CheckingIntegerSorter app = new CheckingIntegerSorter();
        app.start();
    }
}
