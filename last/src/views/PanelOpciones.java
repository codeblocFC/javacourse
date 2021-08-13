package views;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class PanelOpciones extends JPanel implements ActionListener {

    public final static String BTN_SALDO = "Consultar Saldo";
    public final static String BTN_CARGAR = "Cargar";
    public final static String BTN_CREAR = "Crear Clientes";
    public final static String BTN_LISTAR = "Listar Clientes";

    // crear relaciones o atributos
    private JButton btnSaldo;
    private JButton btnCargar;
    private JButton btnCrear;
    private JButton btnListar;

    private Interfaz interfaz;

    public PanelOpciones(Interfaz i) {
        super();
        setLayout(new GridLayout(1, 4));
        setBorder(new TitledBorder("Opciones"));

        interfaz = i;

        // inicializar atributos
        btnSaldo = new JButton(BTN_SALDO);
        btnCargar = new JButton(BTN_CARGAR);
        btnCrear = new JButton(BTN_CREAR);
        btnListar = new JButton(BTN_LISTAR);

        // modificar las propiedades
        btnSaldo.setActionCommand(BTN_SALDO);
        btnCargar.setActionCommand(BTN_CARGAR);
        btnCrear.setActionCommand(BTN_CREAR);
        btnListar.setActionCommand(BTN_LISTAR);

        btnSaldo.addActionListener(this);
        btnCargar.addActionListener(this);
        btnCrear.addActionListener(this);
        btnListar.addActionListener(this);

        // modificar las relaciones o atributos
        // add(btnSaldo);
        // add(btnCargar);
        add(btnCrear);
        add(btnListar);

    }

    public void addClient() {
        String nombre = JOptionPane.showInputDialog(interfaz, "Digita el nombre del cliente");
        if (nombre != null && !nombre.equals("")) {
            interfaz.addClient(nombre);
            interfaz.updateList();
        } else if (nombre != null) {
            JOptionPane.showMessageDialog(interfaz, "Revisa los datos");
        }

    }

    public void listarClientes() {
        JOptionPane.showMessageDialog(interfaz, interfaz.listarClientes());
    }

    @Override // metodo sobrecargado
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals((BTN_SALDO))) {
            System.out.println("Estas viendo el saldo");
            JOptionPane.showMessageDialog(interfaz, "Estas viendo el saldo");
            // JOptionPane.showMessageDialog(this,"Estas viendo el saldo"); //this para que
            // la ventana aparezca sobre el panel
        } else if (e.getActionCommand().equals(btnCargar.getActionCommand())) {
            System.out.println("Estas cargando");
            JOptionPane.showMessageDialog(interfaz, "Vas a recargar", "Recarga Wallet", JOptionPane.WARNING_MESSAGE);
        } else if (e.getActionCommand().equals((BTN_CREAR))) {
            addClient();
        } else if (e.getActionCommand().equals((BTN_LISTAR))) {
            listarClientes();
        }
    }

}
