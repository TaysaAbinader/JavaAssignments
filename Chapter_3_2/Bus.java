package Chapter_3_2;

public class Bus extends AbstractVehicle {

    public Bus (String type, String fuel, String colour, String fuelEfficiency) {
        super(type, fuel, colour, fuelEfficiency);
    }

    @Override
    public String start () {
        return "Bus is starting...";
    }

    @Override
    public String stop () {
        return "Bus is stoping...";
    }

    @Override
    public String charge() {
        return "Bus can't be charged.";
    }
}
