package Chapter_5_1;

public class OddCounter implements Runnable {
    private int number;

    public OddCounter(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= number; i += 2) {
            System.out.println ("Odd thread: " + i);
        }
    }
}
