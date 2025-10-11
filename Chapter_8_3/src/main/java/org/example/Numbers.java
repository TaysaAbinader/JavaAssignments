package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        // 1. Create a List: Create a list of integers, e.g., [10, 5, 8, 20, 15, 3, 12].
        int[] numbers = { 10, 5, 8, 20, 15, 3, 12 };

        // 2. Filter Even Numbers: Use lambda expressions to filter out even numbers from the list.
        int[] evenNumbers = Arrays
                .stream(numbers)
                .filter(number -> number % 2 == 0)
                .toArray();
        System.out.println(Arrays.toString(evenNumbers));

        // 3. Double the Odd Numbers: Use lambda expressions to double the value of odd numbers in the list. Hint: replaceAll()
        int[] doubleOddNumbers = Arrays
                .stream(numbers)
                .filter(number -> number % 2 == 1)
                .map(number -> number * 2)
                .toArray();
        System.out.println(Arrays.toString(doubleOddNumbers));

        // 4. Sum the Numbers: Use lambda expressions to calculate the sum of all numbers in the list.
        int sum = Arrays
                .stream(numbers)
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum);
    }
}
