package Chapter_3_2;

public class Motorcycle extends AbstractVehicle {

    public Motorcycle (String type, String fuel, String colour) {
        super(type, fuel, colour);
    }

    @Override
    public String start () {
        return "Motorcycle is starting...";
    }

    @Override
    public String stop () {
        return "Motorcycle is stoping...";
    }

    @Override
    public String charge() {
        return "Motorcycle can't be charged.";
    }
}
