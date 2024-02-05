import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class MandelbrotSetGenerator {
    private final int width;
    private final int height;
    private static final int MAX_ITER = 1000;

    public MandelbrotSetGenerator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void drawMandelbrot(Graphics g) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double zx, zy, cX, cY;
                zx = zy = 0;
                cX = (x - width / 2.0) * 4.0 / width;
                cY = (y - height / 2.0) * 4.0 / height;
                int iter = 0;

                while (zx * zx + zy * zy < 4 && iter < MAX_ITER) {
                    double tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    iter++;
                }

                int color = iter % 256;
                int rgb = color | (color << 8) | (color << 16);
                image.setRGB(x, y, rgb);
            }
        }

        g.drawImage(image, 0, 0, null);
    }

    public void saveImage(String fileName) throws IOException {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        drawMandelbrot(g2d);
        g2d.dispose();
        ImageIO.write(image, "png", new File(fileName));
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Visualizer::new);
    }
}