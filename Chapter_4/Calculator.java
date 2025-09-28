package Chapter_4;

// In a new project, write a Calculator class that has the ability to sum positive integers. A negative integer should throw an exception.
// The class acts as the model in the MVC pattern. It should have the following methods:
// - A method that resets the calculator to zero.
// - A method that adds an integer to the calculator.
// - A method that returns the current value of the calculator.
// In addition, write a temporary main method that creates an instance of the Calculator class and uses it to calculate the sum of a few integers.

public class Calculator {
    private int total;

    private static final double MY_VALUE = 3.14;
    private final int x;

    // Constructor to initialize the calculator
    public Calculator(int x) {
        this.x = x;
        this.total = 0;
    }

    // Method to reset the calculator to zero
    public void reset() {
        this.total = 0;
    }

    // Method to add a positive integer to the calculator
    public void add(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Only positive integers are allowed.");
        }
        this.total += number;
    }

    // Method to subtract a positive integer from the calculator
    public void subtract(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Only positive integers are allowed.");
        }
        this.total -= number;
    }

    public void displayNumbersFrom1ToN(int n) {
        while (n >= 1) {
            System.out.println(n);
            n--;
        }
    }

    // Method to multiply the current total by a positive integer
    public void multiply(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Only positive integers are allowed.");
        }
        this.total *= number;
    }

    // Method to return the current value of the calculator
    public int getTotal() {
        return this.total;
    }

    // Temporary main method for testing
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        
        try {
            calculator.add(5);
            calculator.add(10);
            System.out.println("Current total: " + calculator.getTotal()); // Should print 15
            
            calculator.add(-3); // This should throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        calculator.reset();
        System.out.println("Total after reset: " + calculator.getTotal()); // Should print 0
    }
}
