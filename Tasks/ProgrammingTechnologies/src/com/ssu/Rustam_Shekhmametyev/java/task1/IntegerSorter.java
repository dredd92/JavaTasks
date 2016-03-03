package com.ssu.Rustam_Shekhmametyev.java.task1;

/**
 * Created by Rustam Shekhmametyev on 3/1/2016.
 */
import java.lang.*;
import java.util.*;
public  class IntegerSorter{
    Random randGenerator = new Random();
    final static int minPartitionForParallel = 1000;
    final static int minPartitionForInsertion = 10;
    final static int maxNumberOfThreads = Runtime.getRuntime().availableProcessors();

    private static void swap(int firstIndex, int secondIndex, int[] array){
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static void insertionSort(int begin, int end, int[] array){
        int j = 0;
        for(int i = begin + 1; i <= end; i++){
            j = i;
            while(j > 0 && array[j - 1] > array[j]){
                swap(j, j - 1, array);
                j--;
            }
        }
    }


    private static void quicksort(int begin, int end, int[] array){
        if(end - begin <= minPartitionForInsertion){
            insertionSort(begin, end, array);
            return;
        }
        int i = begin;
        int j = begin;
        int n = end;
        int mid = array[(begin - end) / 2 + end];
        while(j <= n){
            if (array[j] < mid){
                swap(i, j, array);
                i++;
                j++;
            }else if (array[j] > mid){
                swap(j, n, array);
                n--;
            }else{
                j++;
            }
        }
        if (end - begin > minPartitionForParallel && Thread.activeCount() <= maxNumberOfThreads){
            final int left = begin;
            final int leftMiddle = i;
            final int rightMiddle = j;
            final int right = end;
            final int[] parallelArray = array;
        Thread leftRec = new Thread(new Runnable() {
            public void run() {
                quicksort(left, leftMiddle, parallelArray);
            }
        });
            Thread rightRec = new Thread(new Runnable() {
                public void run() {
                    quicksort(rightMiddle, right, parallelArray);
                }
            });
            leftRec.start();
            rightRec.start();

        }else {
            quicksort(begin, i, array);
            quicksort(j, end, array);
        }
    }

    public static void quicksort(int[] array){
        quicksort(0, array.length - 1, array);
    }
}
