import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class BinaryConverter {

    public BinaryConverter () {}

    //Find the 1 on the binary numbers
    public double binaryIndexFinder (String binary, int fromIndex) {
        for (int i = fromIndex; i < binary.length(); i++){
            if (binary.charAt(i) == '1') {
                return i;
            } else {
                return -1;//check later
            }
        }
    }
    //Calculate the decimals from the indexes of the binary
    public double calculateDecimalperBinary (double index){
        return Math.pow(2, index);
    }


    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        String binaryNumberValue = scanner.nextLine();

        ArrayList<double> decimals = new ArrayList<>();
        double sum = 0;

        BinaryConverter converter = new BinaryConverter();
        int fromIndex = 0;
        double index;
        double indexValue = converter.binaryIndexFinder(binaryNumberValue);

        while (index = indexValue != -1) {
            int power = binaryNumberValue.length() - 1 - index;
            double decimalValue = converter.calculateDecimalperBinary(indexValue);
            decimals.add(decimalValue);
            fromIndex = index + 1;
        }
        for (double number : decimals){
            sum += number;

        }
    System.out.println("ArrayList " + decimals);
    System.out.println("The binary "+ binaryNumberValue + "is in decimals " + sum);
    }
}
