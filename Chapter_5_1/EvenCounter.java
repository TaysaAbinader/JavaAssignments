package Chapter_5_1;

public class EvenCounter implements Runnable {
    private int number;

    public EvenCounter(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i <= number; i += 2) {
            System.out.println ("Even thread: " + i);
        }
    }
}
