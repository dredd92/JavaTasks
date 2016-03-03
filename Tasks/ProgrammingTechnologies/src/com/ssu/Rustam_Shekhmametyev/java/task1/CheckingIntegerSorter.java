package com.ssu.Rustam_Shekhmametyev.java.task1;

import java.io.*;
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

    public void start() throws FileNotFoundException, IOException{
        String basePath = new File("").getAbsolutePath();
        String inputPath = basePath.concat("/IO files/input.txt");
        String outputPath = basePath.concat("/IO files/output.txt");
        File outputFile = new File(outputPath);
        if(outputFile.exists())
            outputFile.delete();
            outputFile.createNewFile();
        PrintWriter output = new PrintWriter(new FileOutputStream(outputPath));
        BufferedReader input = new BufferedReader(new FileReader(inputPath));
        int startNumberOfThreads = Thread.activeCount();
        int size = Integer.parseInt(input.readLine());
        if(size < 0){
            throw new IllegalArgumentException("The size of the array must be a positive integer");
        }
        int[] array = new int[size];
        setRandom(array);
        output.println("Unsorted array: ");
        print(array, output);
        double startTime = System.currentTimeMillis();
        IntegerSorter.quicksort(array);
        while(Thread.activeCount() != startNumberOfThreads){
        }
        output.println("Working time (in seconds): " + (System.currentTimeMillis() - startTime) / 1000);
        output.println("Sorted array: ");
        print(array, output);

        if(checkIfSorted(array)){
            output.println("The array is sorted");
        } else{
            output.println("The array is not sorted. An error in the sorting algorithm occurred.");
        }
        output.close();
    }

    private void print(int[] array, PrintWriter output) throws FileNotFoundException{
        for(int i = 0; i < array.length; i++){
            output.print(array[i] + " ");
        }
        output.println();
    }
}
