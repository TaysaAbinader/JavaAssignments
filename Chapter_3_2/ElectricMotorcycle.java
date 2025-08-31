package Chapter_3_2;

public class ElectricMotorcycle extends AbstractVehicle {

    public ElectricMotorcycle (String type, String fuel, String colour, String fuelEfficiency) {
        super(type, fuel, colour, fuelEfficiency);
    }

    @Override
    public String start () {
        return "Electric motorcycle is starting...";
    }

    @Override
    public String stop () {
        return "Electric motorcycle is stoping...";
    }

    @Override
    public String charge () {
        return "Electric motorcycle is charging...";
    }
}
