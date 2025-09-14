package Chapter_5_1;

import java.util.Scanner;

public class OddEvenThread {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide the maximum number:");
        int number = Integer.parseInt(scanner.nextLine());

        Thread oddThread = new Thread(new OddCounter(number));
        Thread evenThread = new Thread(new EvenCounter(number));

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            System.err.println(e);
        }

        System.out.println("Program end");
    }
}
