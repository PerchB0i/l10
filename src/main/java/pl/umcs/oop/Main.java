package pl.umcs.oop;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ImageProcessor image = new ImageProcessor();
        image.loadImage("image.png");
        image.setBrightness(100);
        image.saveImage("image2.png");
    }
}