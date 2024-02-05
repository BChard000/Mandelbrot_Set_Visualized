import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Visualizer extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;

    public Visualizer() {
        setTitle("Mandelbrot Set Visualizer");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Window window = new Window(WIDTH, HEIGHT);
        add(window);

        JButton saveButton = new JButton("Save Image");
        saveButton.addActionListener(e -> {
            try {
                window.saveImage("mandelbrot_set.png");
                JOptionPane.showMessageDialog(this, "Image saved successfully!");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving image.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
