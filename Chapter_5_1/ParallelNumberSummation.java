package Chapter_5_1;

import java.util.ArrayList;
import java.util.Random;

public class ParallelNumberSummation implements Runnable {
    private final int[] numbers;
    private final int start;
    private final int end;
    private final int threadIndex;
    private int[] sums;

    public ParallelNumberSummation (int[] numbers, int start, int end, int threadIndex, int[] sums) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
        this.threadIndex = threadIndex;   
        this.sums = sums;
    }

    public void run() {
        sums[threadIndex] = 0;
        for (int i = start; i < end; i++) {
            sums[threadIndex] += numbers[i];
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[100000];

        // Fill in numbers with random values from [0..100000].
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * numbers.length);
        }

        int numberOfCores = Runtime.getRuntime().availableProcessors();

        System.out.println("Number of available cores: " + numberOfCores);

        // We're going to use sums to store the (individual) sums from each thread.
        int[] sums = new int[numberOfCores];

        Thread[] threads = new Thread[numberOfCores];

        int threadsRange = Math.round(numbers.length / numberOfCores);

        // Start and end for the first thread ranges.
        int start = 0;
        int end = start + threadsRange;

        for (int i = 0; i < numberOfCores; i++) {
            threads[i] = new Thread(new ParallelNumberSummation(numbers, start, end, i, sums));
            start = end;
            end += threadsRange;
            threads[i].start();
        }

        long sum = 0;

        // Wait until all threads complete their work.
        for (int i = 0; i < numberOfCores; i++) {
            try {
                threads[i].join();    
            } catch (InterruptedException e) {
                System.err.println(e);
            }
            sum += sums[i];
        }

        System.out.println("Total sum: " + sum);
    }
}
