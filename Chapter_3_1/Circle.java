package Chapter_3_1;

public class Circle extends Shape {
    private double radius;
    private double pi = Math.PI;
    
    public Circle (String colour, double radius) {
        super(colour);
        this.radius = radius;
    }
    
    public double getRadius() {
        return this.radius;
    }

    @Override
    public double calculateArea () {
        double circleArea = pi * (Math.pow(radius, 2));
        return circleArea;
    }


    

}
