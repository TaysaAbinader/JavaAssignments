package Chapter_1_4;

import java.util.Scanner;

public class MaxSubarray {

    public MaxSubarray() {}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Array size: ");

        int arraySize = scanner.nextInt();

        int[] intArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            System.out.println("Integer number " + (i + 1) + ": ");
            intArray[i] = scanner.nextInt();
        }

        int maxCount = 0;
        int maxI = 0;
        int maxJ = intArray.length - 1;

        for (int i = 0; i < intArray.length; i++) {
            for (int j = i; j < intArray.length; j++) {
                int counter = 0;
                for (int k = i; k <= j; k++) {
                    counter += intArray[k];
                    if (counter > maxCount) {
                        maxCount = counter;
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
        }
        System.out.println("Max sum: " + maxCount);
        System.out.println("Start index: " + (maxI+1));
        System.out.println("End index: " + (maxJ+1));
    }
}

