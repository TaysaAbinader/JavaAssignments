package org.example.view;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.util.Objects;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;

import org.example.controller.PetController;

public class PetView extends Application {

    public void start (Stage stage){

        final double SPRITE_W = 96;
        final double SPRITE_H = 96;

        PetController controller = new PetController();
        Canvas canvas = new Canvas(700, 400);
        GraphicsContext graphics = canvas.getGraphicsContext2D();

        StackPane layout = new StackPane(canvas);
        Scene scene = new Scene(layout);
        
        stage.setScene(scene);
        stage.setTitle("My Tamagochi");
        stage.show();

        // Move the pet to the middle of the canvas.
        double centerX = canvas.getWidth() / 2.0;
        double centerY = canvas.getHeight() / 2.0;
        controller.movePet(centerX, centerY);
        controller.setTarget(centerX, centerY);

        String imageUrl = Objects.requireNonNull(getClass().getResource("/petImage.png")).toExternalForm();
        Image petImg = new Image(imageUrl, SPRITE_W, SPRITE_H, true, true, true);

        canvas.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
            public void handle (MouseEvent mouseMovedEvent) {
                controller.setTarget(mouseMovedEvent.getX(), mouseMovedEvent.getY());
            }
        });

        canvas.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            public void handle (MouseEvent mouseExitedEvent) {
                controller.stop();
            }
        });

        // Time controlled animation loop.
        new AnimationTimer() {
            // Store the last time frame.
            long lastTime = -1; 

            public void handle (long now) {
                if (lastTime < 0) {
                    lastTime = now;
                    return;
                }

                System.out.println("handle " + now);

                // Convert from nanoseconds to seconds.
                double timeDelta = (now - lastTime)/1_000_000_000.0;

                lastTime = now;

                controller.update(timeDelta);

                // Clear the canvas.
                graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                double x = controller.getPetX();
                double y = controller.getPetY();

                // Center the sprite on (x,y) and draw at fixed size.
                graphics.drawImage(petImg, x - SPRITE_W/2, y - SPRITE_H/2, SPRITE_W, SPRITE_H);
            }
        }.start();

    }
    
}
