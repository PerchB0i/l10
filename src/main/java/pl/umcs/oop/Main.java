package pl.umcs.oop;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ImageProcessor ip = new ImageProcessor();

        try {
            long start = System.currentTimeMillis();
            ip.loadImage("image.png");
            ip.increaseBrightness(40);
            ip.saveImage("image2.png");
            System.out.println(System.currentTimeMillis() - start);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            long start = System.currentTimeMillis();
            ip.loadImage("image.png");
            ip.increaseBrightnessThreads(-2137);
            ip.saveImage("image3.png");
            System.out.println(System.currentTimeMillis() - start);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}