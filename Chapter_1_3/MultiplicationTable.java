import java.lang.Math;
import java.util.Scanner;

public class MultiplicationTable {

    public MultiplicationTable (){}

    public boolean checkAnswer (int a, int b, int prompt){
        int multiplication = a * b;
        int userAnswer = prompt;
        boolean check = false;
        if (multiplication == userAnswer){
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    public static void main (String[] args){
        int points = 0;
        Scanner scanner = new Scanner (System.in);
        MultiplicationTable checker = new MultiplicationTable();


        while (points < 10) {
            int factorA = (int) (Math.random()*10 + 1);
            int factorB = (int) (Math.random()*10 + 1);

            System.out.println(factorA + " x " + factorB + ":");

            int answer = Integer.parseInt(scanner.nextLine());

            boolean checkedAnswer = checker.checkAnswer(factorA, factorB, answer);

            if (checkedAnswer == true){
                points++;
            } else {
                continue;
            }
        }
        System.out.println("Congratulations you got it right 10 times!");
        scanner.close();
    }
}
