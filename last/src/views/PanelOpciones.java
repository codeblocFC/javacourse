package views;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class PanelOpciones extends JPanel implements ActionListener{

    public final static String BTN_SALDO="Consultar Saldo";
    public final static String BTN_CARGAR="Cargar";

    //crear relaciones o atributos
    private JButton btnSaldo;
    private JButton btnCargar;

    private Interfaz interfaz;

    public PanelOpciones(Interfaz i) {
        super();
        setLayout(new GridLayout(2,1));
        setBorder(new TitledBorder("Opciones"));

        interfaz =i;

        //inicializar atributos
        btnSaldo=new JButton(BTN_SALDO);
        btnCargar=new JButton(BTN_CARGAR);

        //modificar las propiedades
        btnSaldo.setActionCommand(BTN_SALDO);
        btnCargar.setActionCommand(BTN_CARGAR);

        btnSaldo.addActionListener(this);
        btnCargar.addActionListener(this);

        //modificar las relaciones o atributos
        add(btnSaldo);
        add(btnCargar);

    }

    @Override //metodo sobrecargado
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getActionCommand().equals((BTN_SALDO))){
            System.out.println("Estas viendo el saldo");
            JOptionPane.showMessageDialog(interfaz,"Estas viendo el saldo");
            //JOptionPane.showMessageDialog(this,"Estas viendo el saldo"); //this para que la ventana aparezca sobre el panel
            }
        else if(e.getActionCommand().equals(btnCargar.getActionCommand())){
            System.out.println("Estas cargando");
            JOptionPane.showMessageDialog(interfaz,"Vas a recarga", "Recarga Wallet", JOptionPane.WARNING_MESSAGE);
        }
    }
    
}
