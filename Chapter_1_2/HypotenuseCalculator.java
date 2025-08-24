package Chapter_1_2;
import java.lang.Math;
import java.util.Scanner;

public class HypotenuseCalculator {

    public HypotenuseCalculator() {
    }
    public double calculate (double value1, double value2) {
        double hypotenuse = Math.hypot(value1, value2);
        return hypotenuse;
    }

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Length of the First leg: ");
        double aValue = Double.parseDouble(scanner.nextLine());
        System.out.println("Length of the Second leg: ");
        double bValue = Double.parseDouble(scanner.nextLine());

        HypotenuseCalculator calculator = new HypotenuseCalculator();

        double hypotenuse = calculator.calculate(aValue, bValue);

        System.out.println("The hypotenuse length is " + hypotenuse);


    }

}
