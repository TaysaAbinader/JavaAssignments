package Chapter_3_1;

public class SportsCar extends Car {

    public SportsCar (String typeName) {
        super(typeName);
    }

    public SportsCar(double tankCapacity, double speed) {
        super(tankCapacity, speed);
    }

    @Override
    public void accelerate(int amount) {
        if (gasolineLevel > 1) {
            if (amount > 0)
                speed = Math.max(0, speed + (amount * 2));
                gasolineLevel -= 2;
        } else
            speed = 0;
    }

    @Override
    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - (amount * 2));
        } else
            speed = 0;
    }

    public static void main(String[] args) {
        SportsCar fancyCar = new SportsCar("Porsche 911");

        fancyCar.fillTank();

        System.out.println("Gasoline level: " + fancyCar.getGasolineLevel());
        System.out.println("Speed: " + fancyCar.getSpeed());

        for (int i = 0; i < 6; i++) {
            fancyCar.accelerate(10);
            System.out.println(fancyCar.getTypeName() + ": speed is " + fancyCar.getSpeed() + " km/h");
        }

         while (fancyCar.getSpeed() > 0) {
            fancyCar.decelerate(10);
            System.out.println(fancyCar.getTypeName() + ": speed is " + fancyCar.getSpeed() + " km/h");
        }
    }
}
