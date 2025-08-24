import java.util.Scanner;

public class Task1 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi! What is your name?");
        String answer = scanner.nextLine();
        
        System.out.printf("Nice to meet you, %s ", answer);
    }
}
