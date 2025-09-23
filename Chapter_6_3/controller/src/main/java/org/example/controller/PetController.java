package org.example.controller;

import org.example.model.Pet;

public class PetController {

    private Pet tamagochi = new Pet(0, 0);

    private double targetX = 0.0;
    private double targetY = 0.0;

    private final double speed = 180.0; //pixels per second

    public PetController () {}

    public void setTarget (double x, double y) {
        this.targetX = x;
        this.targetY = y;
    }

    public void stop () {
        setTarget(tamagochi.getX(), tamagochi.getY());
    }

    public void movePet(double x, double y) {
        tamagochi.move(x, y);
    }

    public double getPetX() {
        return tamagochi.getX();
    }

    public double getPetY() {
        return tamagochi.getY();
    }

    public void update (double timeDelta /* time since last frame, in seconds. */) {
        double deltaX = targetX - tamagochi.getX();
        double deltaY = targetY - tamagochi.getY();

        double distance = Math.hypot(deltaX, deltaY);
        if (distance > 1.0) {
            double step = speed * timeDelta * distance;
            double newX = tamagochi.getX() + (deltaX/step);
            double newY = tamagochi.getY() + (deltaY/step);
            tamagochi.move(newX, newY);
        }
    }
}
