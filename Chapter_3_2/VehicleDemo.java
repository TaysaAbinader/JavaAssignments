package Chapter_3_2;

import java.util.ArrayList;

public class VehicleDemo {

    public static void main (String[] args) {

        ArrayList<AbstractVehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("Car", "Gasoline", "Red"));
        vehicles.add(new Motorcycle("Motorcycle", "Gasoline", "Black"));
        vehicles.add(new Bus ("Bus", "Diesel", "Blue"));
        vehicles.add(new ElectricCar("Electric", "Electric", "White"));
        vehicles.add(new ElectricMotorcycle("Electric", "Electric", "Green"));

        for (AbstractVehicle vehicle : vehicles) {
            System.out.println(vehicle.start());
            System.out.println(vehicle.stop());
            System.out.println(vehicle.charge());
            System.out.println(vehicle.getInfo());
        }
    }

}
