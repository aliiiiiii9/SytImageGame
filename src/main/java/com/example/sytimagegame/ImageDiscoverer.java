package com.example.sytimagegame;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class ImageDiscoverer {
    private Image originalImage;
    private WritableImage currentImage;
    private int width;
    private int height;

    public ImageDiscoverer(Image image) {
        this.originalImage = image;
        this.width = (int)image.getWidth();
        this.height = (int)image.getHeight();

        this.currentImage = new WritableImage(this.width, this.height);
        initImage();
    }

    public void initImage(){
        PixelWriter writer = currentImage.getPixelWriter();
        for (int row = 0; row < this.height; row++) {
            for (int col = 0; col < this.width; col++) {
                double red = Math.random();
                double green = Math.random();
                double blue = Math.random();
                writer.setColor(col, row, new Color(red, green, blue, 1));
            }
        }
    }
    public Image getCurrentImage() {
        return this.currentImage;
    }

    public void startDiscover() {
        System.out.println("Starting discovery...");
        PixelReader reader = originalImage.getPixelReader();
        PixelWriter writer = currentImage.getPixelWriter();
        for (int col = 0; col < this.width; col++) {
            for (int row = 0; row < this.height; row++) {
                Color c = reader.getColor(col, row);
                writer.setColor(col, row, c);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
