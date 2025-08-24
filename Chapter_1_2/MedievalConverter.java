package Chapter_1_2;
import java.util.Scanner;
import java.lang.Math;


public class MedievalConverter {
    private static float gramsLuotiRatio = 13.28f;
    private static int naulaLuotiRatio = 32;
    private static int leiviskaNaulaRatio = 20;
    private static int leiviskaLuotiRatio = leiviskaNaulaRatio * naulaLuotiRatio;

    public MedievalConverter() {}

    public float gramsToLuoti (int grams) {
        return grams / gramsLuotiRatio;
    }

    public int luotiToLeiviska (float luoti) {
        return (int) (luoti / leiviskaLuotiRatio);
    }

    public int luotiToNaula (float luoti) {
        return (int) (luoti / naulaLuotiRatio);
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Weight in grams: ");
        int gramsValue = Integer.parseInt(scanner.nextLine());

        MedievalConverter converter = new MedievalConverter();

        // Total luoti (from grams).
        float luotiValue = converter.gramsToLuoti(gramsValue);

        // Total leiviskä (integer).
        int leiviskaValue = converter.luotiToLeiviska(luotiValue);
        // Remainder luoti (minus leiviskä).
        float luotiMinusLeiviska = luotiValue - (leiviskaValue * leiviskaLuotiRatio);

        // Total naula (integer).
        int naulaValue = converter.luotiToNaula(luotiMinusLeiviska);
        // Remainder luoti (minus leiviskä minus naula).
        float luotiMinusNaula = luotiMinusLeiviska - (naulaValue * naulaLuotiRatio);

        // Round to the second decimal.
        luotiValue = Math.round(luotiMinusNaula * 100f) / 100f;

        System.out.println("Weigth (g): " + gramsValue);
        System.out.println(gramsValue + " grams is " + leiviskaValue + " leiviskä, " + naulaValue + " naula, and " + luotiValue + " luoti.");
    }

}
