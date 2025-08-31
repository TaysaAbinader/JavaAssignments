package Chapter_3_2;

public class Bus extends AbstractVehicle {

    public Bus (String type, String fuel, String colour) {
        super(type, fuel, colour);
    }

    @Override
    public String start () {
        return "Bus is starting...";
    }

    @Override
    public String stop () {
        return "Bus is stoping...";
    }
}
