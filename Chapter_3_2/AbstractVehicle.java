package Chapter_3_2;

public abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    private String type;
    private String fuel;
    private String colour;
    private String fuelEfficiency;

    public AbstractVehicle (String type, String fuel, String colour, String fuelEfficiency) {
        this.type = type;
        this.fuel = fuel;
        this.colour = colour;
        this.fuelEfficiency = fuelEfficiency;
    }

    @Override
    public String getInfo () {
        return "Type: " + type + "\nFuel: " + fuel + "\nColour: " + colour + "\nFuel efficiency: " + fuelEfficiency + "\n";
    }

    @Override
    public String calculateFuelEfficiency () {
        return fuelEfficiency;
    }
}
