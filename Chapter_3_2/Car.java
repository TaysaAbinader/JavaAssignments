package Chapter_3_2;

public class Car implements Vehicle {
    private String type;
    private String fuel;
    private String colour;

    public Car (String type, String fuel, String colour) {
        this.type = type;
        this.fuel = fuel;
        this.colour = colour;
    }

    public String start () {
        return "Car is starting...";
    }

    public String stop () {
        return "Car is stoping...";
    }

    public String getInfo () {
        return "Type: " + type + "\nFuel: " + fuel + "\nColour: " + colour + "\n";
    }

}
