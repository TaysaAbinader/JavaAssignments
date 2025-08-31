package Chapter_3_2;

public class Car extends AbstractVehicle {

    public Car (String type, String fuel, String colour) {
        super(type, fuel, colour);
    }

    @Override
    public String start () {
        return "Car is starting...";
    }

    @Override
    public String stop () {
        return "Car is stoping...";
    }

    @Override
    public String charge() {
        return "Car can't be charged.";
    }
}
