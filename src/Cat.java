public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println("The cat named " + name + " says: Meow!");
    }

    public static void main(String[] args) {
        Cat whiskers = new Cat("Whiskers");
        Cat rex = new Cat("Rex");

        whiskers.meow();
        whiskers.meow();
        rex.meow();
        whiskers.meow();
    }
}
