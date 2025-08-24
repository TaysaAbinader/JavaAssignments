import java.util.Scanner;

public class Task3 {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the third number:");
        int third = Integer.parseInt(scanner.nextLine());

        int sum = first + second + third;
        int product = first * second * third;
        float average = sum / 3.0f;

        System.out.printf("The sum of the numbers is %s%nThe product of the numbers is %s%nThe average of the numbers is %s%n", sum, product, average);
        scanner.close();
    }
}

