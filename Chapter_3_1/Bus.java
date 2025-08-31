package Chapter_3_1;

public class Bus extends Car {
    private int passengers;

    public Bus (String typeName) {
        super(typeName);
        this.passengers = 0;
    }

    public void passengerEnter(int addPassenger) {
        passengers += addPassenger;
    }

    public void passengerLeave(int subtractPassenger) {
        if (subtractPassenger > passengers) {
            System.err.println("Error: not enough passengers (" + subtractPassenger + ") to subtract from " + passengers + " in the bus.");
            return;
        }
        passengers -= subtractPassenger;
    }

    public int getPassenger () {
        return this.passengers;
    }

    public static void main(String[] args) {

        Bus bus1 = new Bus("BYD");

        bus1.fillTank();

        bus1.passengerEnter(8);

        System.out.println("The bus has " + bus1.getPassenger() + " passengers.");

        for (int i = 0; i < 6; i++) {
            bus1.accelerate(10);
            System.out.println(bus1.getTypeName() + ": speed is " + bus1.getSpeed() + " km/h");
        }

         while (bus1.getSpeed() > 0) {
            bus1.decelerate(10);
            System.out.println(bus1.getTypeName() + ": speed is " + bus1.getSpeed() + " km/h");
        }
        bus1.passengerLeave(2);

        System.out.println("The bus has " + bus1.getPassenger() + " passengers.");
    }

}
