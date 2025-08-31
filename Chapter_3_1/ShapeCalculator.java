package Chapter_3_1;

import java.util.ArrayList;

public class ShapeCalculator {

    public static void main(String[] args) {

        ArrayList<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle("Red",5));
        shapes.add(new Rectangle("Blue",4, 6));
        shapes.add(new Triangle("Purple", 3.0, 8));
        
        for (Shape item : shapes) {
            if (item instanceof Circle circle) {
                System.out.println("Circle of colour " + circle.getColour() + " and radius " + circle.getRadius() + " has area of: " + circle.calculateArea());
            } else if (item instanceof Rectangle rectangle) {
                System.out.println("Rectangle of colour " + rectangle.getColour() + ", width " + rectangle.getWidth() + " and height of " + rectangle.getHeight() + " has area of: " + rectangle.calculateArea());
            } else if (item instanceof Triangle triangle) {
                System.out.println("Triangle of colour " + triangle.getColour() + ", base " + triangle.getBase() + " and height of " + triangle.getHeight() + " has area of: " + triangle.calculateArea());
            }
        }
    }
}
