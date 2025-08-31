package Chapter_3_2;

import java.util.ArrayList;

public class VehicleDemo {

    public static void main (String[] args) {

        ArrayList<AbstractVehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("Car", "Gasoline", "Red", "0.1 l/km"));
        vehicles.add(new Motorcycle("Motorcycle", "Gasoline", "Black", "0.05 l/km"));
        vehicles.add(new Bus ("Bus", "Diesel", "Blue", "0.2 l/km"));
        vehicles.add(new ElectricCar("Electric", "Electric", "White", "10 KWh/km"));
        vehicles.add(new ElectricMotorcycle("Electric", "Electric", "Green", "5 KWh/km"));

        for (AbstractVehicle vehicle : vehicles) {
            System.out.println(vehicle.start());
            System.out.println(vehicle.stop());
            System.out.println(vehicle.charge());
            System.out.println(vehicle.getInfo());
        }
    }

}
