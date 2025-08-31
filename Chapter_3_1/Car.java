package Chapter_3_1;

public class Car {
    protected double speed = 0;
    protected double gasolineLevel = 0;
    private String typeName;
    private double tankCapacity;
    
    public Car(String typeName) {
        this.typeName = typeName;
    }

    public Car(double tankCapacity, double speed) {
        this.speed = speed;
        this.tankCapacity = tankCapacity;
    }

    public void accelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed + amount);
                gasolineLevel -= 1;
        } else
            speed = 0;
    }

    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else
            speed = 0;
    }

    double getSpeed() {
        return speed;
    }

    String getTypeName() {
        return typeName;
    }

    void fillTank() {
        gasolineLevel = 100;
    }

    double getGasolineLevel() {
        return gasolineLevel;
    }

    // Cruise control

    private boolean cruiseControlActive = false;
    private int targetSpeed = 0;

    // Immutable values
    public int minCruiseControlSpeed = 10;
    public int maxCruiseControlSpeed = 100;

    public boolean getCruiseControlActive() {
        return cruiseControlActive;
    }

    public boolean checkInvalidCruiseControlTargetSpeed() {
        boolean invalidTargetSpeed = targetSpeed > maxCruiseControlSpeed || targetSpeed < minCruiseControlSpeed;
        if (invalidTargetSpeed) {
            cruiseControlActive = false;
        }
        return invalidTargetSpeed;
    }

    public boolean setCruiseControlActive(boolean cruiseControlActive) {
        this.cruiseControlActive = cruiseControlActive;

        if (this.cruiseControlActive) {
            if (checkInvalidCruiseControlTargetSpeed()) {
                return false;
            }

            // Accelerate or decelerate accordingly.
            while (speed != targetSpeed) {
                if (speed > targetSpeed) {
                    decelerate(1);
                } else {
                    accelerate(1);
                }
            }
        }
    
        return true;
    }

    public int getCruiseControlTargetSpeed() {
        return targetSpeed;
    }

    public boolean setCruiseControlTargetSpeed(int targetSpeed) {
        this.targetSpeed = targetSpeed;

        if (checkInvalidCruiseControlTargetSpeed()) {
            return false;
        }

        return true;
    }

}
