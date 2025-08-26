package Chapter_2_1;

public class CarDriver {
    public static void main(String[] args) {
        Car myCar;

        myCar = new Car("Toyota Corolla");
        myCar.fillTank();

        for (int i = 0; i < 6; i++) {
            myCar.accelerate(10);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        // Cruise control

        // Check invalid target speed
        boolean isTargetSpeedValid = myCar.setCruiseControlTargetSpeed(101);
        if (isTargetSpeedValid == false) {
            System.out.println("Invalid taget speed: " + myCar.getCruiseControlTargetSpeed() + " km/h (min: " + myCar.minCruiseControlSpeed + " km/h  max: " + myCar.maxCruiseControlSpeed + " km/h), cruise control off.");
        }

        // Speed is 0
        myCar.setCruiseControlTargetSpeed(50);
        boolean isCruiseControlActive = false;
        isCruiseControlActive = myCar.setCruiseControlActive(true);

        // Speed should be 50.
        if (isCruiseControlActive) {
            System.out.println("Cruise control active, speed is now " + myCar.getSpeed() + " km/h");
        }
    }
}
