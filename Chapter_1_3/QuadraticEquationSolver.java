import java.lang.Math;
import java.util.Scanner;

public class QuadraticEquationSolver {

    public QuadraticEquationSolver () {}


    //Calculate the discriminant of a quadratic function
    public double calculateDiscriminant(double coefficientA, double coefficientB, double coefficientC){
        double discriminant = Math.exp(coefficientB) - (4 * coefficientA * coefficientC);
        return discriminant;
    }
    
    //Calculate the first root
    public double calculateRootOne(double coefficientA, double coefficientB, double discriminant){
        double rootOne = (- coefficientB + Math.sqrt(discriminant)) / (2 * coefficientA);
        return rootOne;
    }

    //Calculate the second root
    public double calculateRootTwo(double coefficientA, double coefficientB, double discriminant){
        double rootTwo = (- coefficientB + Math.sqrt(discriminant)) / (2 * coefficientA);
        return rootTwo;
    }

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        //Take the inputs of the coefficients of the quadratic equation
        System.out.println("Coefficient a: ");
        double coefficientAvalue = Double.parseDouble(scanner.nextLine());
        System.out.println("Coefficient b: ");
        double coefficientBvalue = Double.parseDouble(scanner.nextLine());
        System.out.println("Coefficient c: ");
        double coefficientCvalue = Double.parseDouble(scanner.nextLine());

        //Calculate the discriminant
        QuadraticEquationSolver solver = new QuadraticEquationSolver();

        double discriminantValue = solver.calculateDiscriminant(coefficientAvalue, coefficientBvalue, coefficientCvalue);

        //Check if the equation has real roots and print the results
        if(discriminantValue < 0){
            System.out.println("This equation has no real roots.");
        }else {
            double rootOneValue = solver.calculateRootOne(coefficientAvalue, coefficientBvalue, discriminantValue);
            System.out.println("Root one (x1) = " + rootOneValue);

            double rootTwoValue = solver.calculateRootTwo(coefficientAvalue, coefficientBvalue, discriminantValue);
            System.out.println("Root two (x2) = " + rootTwoValue);
        }
    }
}
