package org.example.model;

public class Pet {
    private double x;
    private double y;

    public Pet (double x, double y) {
        move(x, y);
    }

    public double getX () {
        return x;
    }

    public double getY () {
        return y;
    }

    public void move (double x, double y) {
        this.x = x;
        this.y = y;
    }
}
