package Chapter_1_4;

import java.util.Random;
import java.util.Scanner;

public class NameGenerator {

    public NameGenerator() {}

    public static void main (String[] args) {
        String[] firstNames = new String[] {"John", "Mary", "Jane", "Gary", "Jason", "Julia"};
        String[] lastNames = new String[] {"Doe", "Dallas", "Miller", "Jackson", "McCallister", "Kelly"};

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many names to generate: ");

        int nameQuantity = Integer.parseInt(scanner.nextLine());
        scanner.close();

        Random randomizer = new Random();

        for (int i = 0; i < nameQuantity; i++) {
            int indexFirstName = randomizer.nextInt(firstNames.length - 1);
            String firstName = firstNames[indexFirstName];

            int indexLastName = randomizer.nextInt(lastNames.length - 1);
            String lastName = lastNames[indexLastName];

            System.out.println(firstName + " " + lastName);
        }
    }
}
