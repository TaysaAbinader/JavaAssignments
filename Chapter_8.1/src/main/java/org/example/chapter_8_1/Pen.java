package org.example.chapter_8_1;

public class Pen {
    public enum Color {
        RED("red"),
        GREEN("green"),
        BLUE("blue");

        private final String color;

        Color(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return color;
        }
    };

    private boolean capped = true;
    private Color color = Color.RED;

    public Pen() {}

    public Pen(Color color) {
        this.color = color;
    }

    public void capOn() {
        this.capped = true;
    }

    public void capOff() {
        this.capped = false;
    }

    public void changeColor(Color newColor) {
        if (capped) {
            this.color = newColor;
        }
    }

    public String draw() {
        if (capped){
            return "";
        } return "Drawing " + color.toString();
    }
}
