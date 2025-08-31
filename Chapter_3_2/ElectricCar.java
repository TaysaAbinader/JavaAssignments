package Chapter_3_2;

public class ElectricCar extends AbstractVehicle {

    public ElectricCar (String type, String fuel, String colour, String fuelEfficiency) {
        super(type, fuel, colour, fuelEfficiency);
    }

    @Override
    public String start () {
        return "Electric car is starting...";
    }

    @Override
    public String stop () {
        return "Electric car is stoping...";
    }

    @Override
    public String charge () {
        return "Electric car is charging...";
    }
}


