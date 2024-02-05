import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Window extends JPanel {
    private final int width;
    private final int height;

    public Window(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        MandelbrotSetGenerator generator = new MandelbrotSetGenerator(width, height);
        generator.drawMandelbrot(g);
    }

    public void saveImage(String fileName) throws IOException {
        MandelbrotSetGenerator generator = new MandelbrotSetGenerator(width, height);
        generator.saveImage(fileName);
    }
}
