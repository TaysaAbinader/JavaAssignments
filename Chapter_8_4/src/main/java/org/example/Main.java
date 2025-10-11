package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double[] numbers = {2.5, 3.0, 4.5, 6.0, 7.5};

        // Task 1: Calculate mean of an array in functional way (e.g. no for-loops).
        double mean = Arrays.stream(numbers)
                .average()
                .orElse(Double.NaN);  // returns NaN if array is empty

        System.out.println("Mean: " + mean);

        // Task 2: Filtering and Transforming a List of Numbers.
        int[] integers = {1, 2, 3, 4, 5};
        int result = Arrays
                .stream(integers)
                .filter(n -> n % 2 == 1)        // 1. filter out even numbers
                .map(n -> n * 2)                // 2. double each even number
                .reduce(0, Integer::sum);   // 3. Find the sum of the resulting numbers
        System.out.println("Filtered and transformed list: " + result);
    }
}