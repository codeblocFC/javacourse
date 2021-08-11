package views;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controlador;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Interfaz extends JFrame {

    private PanelOpciones panelOpciones;
    private PanelClientes panelClientes;
    private PanelWallet panelWallet;
    private PanelTransactions panelTransactions;

    private Controlador controlador;

    public Interfaz() {
        super();
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Wallet");
        setLayout(new BorderLayout());

        controlador = new Controlador();

        // panelOpciones=new PanelOpciones();
        panelOpciones = new PanelOpciones(this); // muestraventana en medio del frame interfaz
        panelClientes = new PanelClientes(this);
        panelWallet= new PanelWallet(this);
        panelTransactions= new PanelTransactions(this);

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(1,3));
        panelCentral.add(panelClientes);
        panelCentral.add(panelWallet);
        panelCentral.add(panelTransactions);

        add(panelOpciones, BorderLayout.SOUTH);
        add(panelCentral, BorderLayout.CENTER);
        updateList();
    }

    public void addClient(String nombre) {
        controlador.addClient(nombre);
        

    }

    public String listarClientes() {
        return controlador.listarClientes();
    }

    public void updateList(){
        panelClientes.updateList((controlador.getClientsData()));
    }

    public void getWalletUser(int id){
        panelWallet.updateWallet(controlador.getWalletUser(id).getWallet());
    }

    public static void main(String[] args) {
        Interfaz vistaPrincipal = new Interfaz();
        vistaPrincipal.setVisible(true);
    }
}