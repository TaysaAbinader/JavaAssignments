import java.util.Scanner;

public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println("The cat named " + name + " says: Meow!");
    }

    public static void main(String[] args) {
        // Create an instance of the Cat class with a name
        Scanner reader = new Scanner(System.in);

        System.out.print("Cat's name: ");
        String catName = reader.nextLine();
        if (catName.isEmpty){
            System.out.print("Cat's name: ");
            catName = reader.nextLine();
        } else {
            Cat cat = new Cat(catName);
        }

    }
    // Call the meow method on the cat instance
        cat.meow();
    }
}