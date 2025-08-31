package Chapter_3_2;

public abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    private String type;
    private String fuel;
    private String colour;

    public AbstractVehicle (String type, String fuel, String colour) {
        this.type = type;
        this.fuel = fuel;
        this.colour = colour;
    }

    @Override
    public String getInfo () {
        return "Type: " + type + "\nFuel: " + fuel + "\nColour: " + colour + "\n";
    }
}
