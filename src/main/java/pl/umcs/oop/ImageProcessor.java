package pl.umcs.oop;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessor {
    private BufferedImage image;

    public void loadImage(String path) throws IOException {
        this.image = ImageIO.read(new File(path));
    }

    public void saveImage(String path) throws IOException {
        ImageIO.write(this.image, "png", new File(path));
    }

    public void setBrightness(int v) {
        for (int x = 0; x <= this.image.getWidth(); x++) {
            for (int y = 0; 0 <= this.image.getHeight(); y++)
            {
                this.image.setRGB(x, y, brightenPixel(this.image.getRGB(x, y), v));
            }
        }
    }

    private int brightenPixel(int pixel, int factor) {
        int blue = checkColor((pixel&255),factor);
        int green = checkColor(((pixel >> 8)&255),factor);
        int red = checkColor(((pixel >> 16)&255),factor);

        int newPixel = red;
        newPixel = (newPixel << 8) + green;
        newPixel = (newPixel << 8) + blue;

        return newPixel;
    }

    private int checkColor(int color, int factor) {
        if ((color + factor) > 255)
            return 255;
        return color+factor;
    }
}
