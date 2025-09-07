package Chapter_3_4;

import java.util.ArrayList;

public class FibonacciSequence {

    public static long generateNumber(int size) {
        ArrayList<Long> fibonacciSequence = new ArrayList<>();
        if (size <= 2) {
            System.err.println("Fibonacci sequence needs to be bigger than 2 numbers.");
            return 0;
        }

        fibonacciSequence.add(0L); // first number
        fibonacciSequence.add(1L); // second number

        // Start from the 3rd sequence number onwards.
        for (int i = 2; i <= size; i++) {
            // Fn = Fn-2 + Fn-1
            long fn2 = fibonacciSequence.get(i - 2); // Fn-2
            long fn1 = fibonacciSequence.get(i - 1); // Fn-1
            long fn = fn2 + fn1; // Fn
            fibonacciSequence.add(fn);
        }

        return fibonacciSequence.getLast();
    }

    public static void main(String[] args) {
        long number = FibonacciSequence.generateNumber(60);
        System.out.println("The Fibonacci sequence for 60 numbers is " + number);
    }
}
