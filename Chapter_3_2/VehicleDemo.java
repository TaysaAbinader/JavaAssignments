package Chapter_3_2;

import java.util.ArrayList;

public class VehicleDemo {

    public static void main (String[] args) {

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("Car", "Electric", "White"));
        vehicles.add(new Motorcycle("Motorcycle", "Gasoline", "Black"));
        vehicles.add(new Bus ("Bus", "Diesel", "Blue"));

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.start());
            System.out.println(vehicle.stop());
            System.out.println(vehicle.getInfo());
        }
    }

}
