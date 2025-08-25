import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class BinaryConverter {

    public BinaryConverter () {}

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Give me a binary number, I'll convert it to decimal: ");
        String binaryString = scanner.nextLine();

        double counter = 0;

        for (int i = 0; i < binaryString.length(); i++) {
            char item = binaryString.charAt(i);
            if (item == '0') {
                continue;
            } else if (item == '1') {
                counter += Math.pow(2, (binaryString.length() - 1) -i);
            } else {
               System.out.println("Error: " + binaryString + " is not a binary string.");
               return;
            }
        }

        System.out.println(counter);
    }
}
