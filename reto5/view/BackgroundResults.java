package view;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundResults extends JPanel {

    public BackgroundResults() {
        super();
    }

    public void paintComponent(Graphics g) {
        ImageIcon img = new ImageIcon(getClass().getResource("/lib/MTIC2.jpg"));
        g.drawImage(img.getImage(), 0, 0, 600, 440, null);
        setOpaque(false);
        super.paintComponent(g);
    }
}