package views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import model.Wallet;

import java.awt.GridLayout;

public class PanelWallet extends JPanel{
    private JLabel lblSaldo;
    private JLabel lblid;
    private JLabel lblEstado;
    private Interfaz interfaz;;

    public PanelWallet(Interfaz i) {
    super();
    setBorder(new TitledBorder("Detalle Wallet"));
    setLayout(new GridLayout());

    JPanel panelAux=new JPanel();
    panelAux.setLayout(new GridLayout(3,1));
    panelAux.setBorder(new EmptyBorder(20,20,10,10));
    interfaz=i;

    lblEstado=new JLabel("Saldo: ");
    lblSaldo=new JLabel("Estado: ");
    lblid=new JLabel("ID: ");

    panelAux.add(lblSaldo);
    panelAux.add(lblEstado);
    panelAux.add(lblid);

    add(panelAux);
    }

    public void updateWallet(Wallet w) {
        lblSaldo.setText("Saldo: "+w.getSaldo());
        lblEstado.setText("Estado: "+w.getTieneLimite());
        lblid.setText("ID: "+w.getId());
        
    }
}
    

