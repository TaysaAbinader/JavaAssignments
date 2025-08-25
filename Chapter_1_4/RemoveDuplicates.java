package Chapter_1_4;

import java.util.Scanner;
import java.util.ArrayList;

public class RemoveDuplicates {

    public RemoveDuplicates() {}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Array size: ");

        int arraySize = scanner.nextInt();

        int[] intArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            System.out.println("Integer number " + (i + 1) + ": ");
            intArray[i] = scanner.nextInt();
        }

        ArrayList<Integer> nonRepeated = new ArrayList();

        for (int i = 0; i < arraySize; i++) {
            int x = intArray[i];
            // -1 means the value is not contained in the non-repeated list.
            if (nonRepeated.indexOf(x) == -1) {
                nonRepeated.add(x);
            }
        }
        System.out.println("Array without duplicates: " + nonRepeated);
    }
}
