package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class RequestPanel extends JPanel implements ActionListener {

    public final static String BTN_REQ1 = "Requerimiento 1";
    public final static String BTN_REQ2 = "Requerimiento 2";
    public final static String BTN_REQ3 = "Requerimiento 3";

    private JButton btnReq1;
    private JButton btnReq2;
    private JButton btnReq3;

    private Interfaz interfaz;

    public RequestPanel(Interfaz i) {
        super();
        setLayout(new GridLayout(1, 4));
        setBorder(new TitledBorder("OPCIONES"));
        setSize(600, 50);

        interfaz = i;

        btnReq1 = new JButton(BTN_REQ1);
        btnReq2 = new JButton(BTN_REQ2);
        btnReq3 = new JButton(BTN_REQ3);

        btnReq1.setActionCommand(BTN_REQ1);
        btnReq2.setActionCommand(BTN_REQ2);
        btnReq3.setActionCommand(BTN_REQ3);

        btnReq1.addActionListener(this);
        btnReq2.addActionListener(this);
        btnReq3.addActionListener(this);

        add(btnReq1);
        add(btnReq2);
        add(btnReq3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals((BTN_REQ1))) {
            interfaz.printResults1();
        } else if (e.getActionCommand().equals(BTN_REQ2)) {
            interfaz.printResults2();
        } else if (e.getActionCommand().equals((BTN_REQ3))) {
            interfaz.printResults3();
        }
    }
}