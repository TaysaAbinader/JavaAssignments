import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumberCalculator {

    public PrimeNumberCalculator () {}

    public boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Starting number: ");
        int startNumber = Integer.parseInt(scanner.nextLine());

        System.out.println("Ending number: ");
        int endNumber = Integer.parseInt(scanner.nextLine());

        scanner.close();

        if (startNumber >= endNumber) {
            System.out.println("Error: " + startNumber + " is higher than " + endNumber);
            return;
        }

        ArrayList<Integer> primeNumbers = new ArrayList<>();

        PrimeNumberCalculator calculator = new PrimeNumberCalculator();

        for (int i = startNumber; i <= endNumber; i++) {
            if (calculator.isPrime(i)) {
                primeNumbers.add(i);
            }
        }

        for (int primeNumber : primeNumbers) {
            System.out.println(primeNumber + " is prime.");
        }
    }
}
