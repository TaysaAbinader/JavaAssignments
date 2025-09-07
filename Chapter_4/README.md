# Calculator Class

The `Calculator` class is a simple implementation of a calculator that operates on positive integers. It is designed to follow the Model-View-Controller (MVC) pattern, where the class acts as the model.

The source code is provided below:
```java
package Chapter_4;

public class Calculator {
    private int total;

    // Constructor to initialize the calculator
    public Calculator() {
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
```

Below is a breakdown of its functionality:

## Features

### 1. Constructor
- Initializes the calculator's total to `0`.

### 2. Methods
#### a. `reset()`
- Resets the calculator's total to `0`.

#### b. `add(int number)`
- Adds a positive integer to the current total.
- Throws an `IllegalArgumentException` if the input is negative.

#### c. `subtract(int number)`
- Subtracts a positive integer from the current total.
- Throws an `IllegalArgumentException` if the input is negative.

#### d. `multiply(int number)`
- Multiplies the current total by a positive integer.
- Throws an `IllegalArgumentException` if the input is negative.

#### e. `displayNumbersFrom1ToN(int n)`
- Prints numbers from `n` down to `1` in descending order.

#### f. `getTotal()`
- Returns the current total of the calculator.

### 3. Temporary `main` Method
- Demonstrates the usage of the `Calculator` class:
    - Adds positive integers to the total.
    - Handles exceptions for negative inputs.
    - Resets the calculator and displays the total.

## Example Usage
```java
Calculator calculator = new Calculator();

try {
        calculator.add(5);
        calculator.add(10);
        System.out.println("Current total: " + calculator.getTotal()); // Output: 15

        calculator.add(-3); // Throws an exception
} catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
}

calculator.reset();
System.out.println("Total after reset: " + calculator.getTotal()); // Output: 0
```

## Notes
- The class enforces the use of positive integers for all operations.
- The `main` method is for testing purposes and can be removed in production.
- Additional methods like `subtract` and `multiply` extend the functionality beyond summation.
- The `displayNumbersFrom1ToN` method is unrelated to the calculator's core functionality but demonstrates looping logic.
