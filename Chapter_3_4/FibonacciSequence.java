package Chapter_3_4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FibonacciSequence {

    public static ArrayList<Long> generate(int size) {
        ArrayList<Long> fibonacciSequence = new ArrayList<>();
        if (size <= 2) {
            System.err.println("Fibonacci sequence needs to be bigger than 2 numbers.");
            return fibonacciSequence;
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

        return fibonacciSequence;
    }

    public static void main(String[] args) {
        ArrayList<Long> fibonacciSequence = FibonacciSequence.generate(60);
        System.out.println("The Fibonacci sequence for 60 numbers is " + fibonacciSequence.getLast());

        String fileName = "Chapter_3_4/fibonacci-numbers.csv";
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Long number : fibonacciSequence) {
                bufferedWriter.write(number.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            System.out.println("File written: " + fileName);
        } catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
