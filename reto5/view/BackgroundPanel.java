package view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class BackgroundPanel extends JPanel implements ActionListener{

    private JButton btnInfo;
    private JButton btnHome;
    private Interfaz interfaz;
    

    public BackgroundPanel(Interfaz i) {
        super();
        setLayout(null);
        interfaz=i;
        btnInfo = new JButton(new ImageIcon(getClass().getResource("/lib/INFO.png")));
        btnInfo.setActionCommand("INFO");
        btnInfo.addActionListener(this);
        btnHome = new JButton(new ImageIcon(getClass().getResource("/lib/HOME.png")));
        btnHome.setActionCommand("HOME");
        btnHome.addActionListener(this);

        add(btnHome);
        add(btnInfo);

        btnInfo.setBounds(550, 150, 50, 50);
        btnHome.setBounds(0, 0, 50, 50);
    }

    public void paintComponent(Graphics g) {
        ImageIcon img = new ImageIcon(getClass().getResource("/lib/MTIC1.jpg"));
        g.drawImage(img.getImage(), 0, 0, 600, 200, null);
        setOpaque(false);
        super.paintComponent(g);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(("INFO"))) {
            JOptionPane.showMessageDialog(this,
                    "Desarrollado por\nFREDY CASALLAS ®\nMision TIC2022\nUniversidad Tecnológica de Pereira");
        }else if (e.getActionCommand().equals(("HOME"))) {
            interfaz.clear();
        }
    }
}