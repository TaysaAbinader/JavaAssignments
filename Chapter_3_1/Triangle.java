package Chapter_3_1;

public class Triangle extends Shape {
    private double base;
    private double height;
    private double constant = 0.5;

    public Triangle (String colour, double base, double height) {
        super(colour);
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return this.base;
    }

    public double getHeight() {
        return this.height;
    }

    @Override
    public double calculateArea () {
        double triangleArea = constant * base * height;
        return triangleArea;
    }

}
