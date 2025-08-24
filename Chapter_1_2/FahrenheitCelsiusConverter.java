package Chapter_1_2;
import java.util.Scanner;

public class FahrenheitCelsiusConverter {
    private static float multiplier = 0.5556f;
    private static int offset = 32;

    public FahrenheitCelsiusConverter() {
    }

    public float convert (float fahrenheitValue) {
        return (fahrenheitValue - offset) * multiplier;
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature in Fahrenheit: ");
        float fahrenheitValue = Float.parseFloat(scanner.nextLine());

        FahrenheitCelsiusConverter converter = new FahrenheitCelsiusConverter();

        float celsiusValue = converter.convert(fahrenheitValue);

        System.out.println("The temperature in Celsius is " + celsiusValue);


    }

}
