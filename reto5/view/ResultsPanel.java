package view;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import java.awt.Graphics;

import model.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

public class ResultsPanel extends JPanel {

    private JTextArea resultsView;

    public ResultsPanel(Interfaz i) {
        super();
        setLayout(new GridLayout(1, 1));
        setBorder(new TitledBorder(null,"RESULTADO",0, 0, null, Color.WHITE));
        
        
        resultsView = new JTextArea();
        resultsView.setEditable(false);
        JScrollPane sp = new JScrollPane(resultsView);
        add(sp, BorderLayout.CENTER);

    }

    public void paintComponent(Graphics g) {
        ImageIcon img = new ImageIcon(getClass().getResource("/lib/MTIC2.jpg"));
        g.drawImage(img.getImage(), 0, 0, 600, 440, null);
        setOpaque(false);
        super.paintComponent(g);
    }

    public void printRequest1(ArrayList<Request1> req1s) {
        resultsView.setText("");
        resultsView.setText("\t\t♦♦♦ RESULTADO REQUERIMIENTO 1 ♦♦♦\n\n");
        resultsView.append(
                "® Proyectos no pagados, cuyo total en la cantidad de compra supera los 50, agrupados por id del proyecto ®\n\n");
        resultsView.append("ID_PROYECTO\t\t" + "PAGADO\t\t" + "PROVEEDOR\t\t" + "TOTAL\n");
        for (Request1 req1 : req1s) {
            resultsView.append(req1.toString() + "\n");
        }
    }

    public void printRequest2(ArrayList<Request2> req2s) {
        resultsView.setText("");
        resultsView.setText("\t\t♦♦♦ RESULTADO REQUERIMIENTO 2 ♦♦♦\n\n");
        resultsView.append(
                "® Proyectos iniciados en los últimos años, ordenados desde el más antiguo al más reciente, cuyos\n   estratos sean mayores o iguales a 5, los cuales no sean financiables, pero el porcentaje de cuota\n   inicial sea mayor al 30% ®\n\n");
        resultsView.append("ESTRATO\t" + "FECHA INICIO\t\t" + "FINANCIABLE\t\t" + "PORCENTAJE\n");
        for (Request2 req2 : req2s) {
            resultsView.append(req2.toString() + "\n");
        }
    }

    public void printRequest3(ArrayList<Request3> req3s) {
        resultsView.setText("");
        resultsView.setText("\t\t♦♦♦ RESULTADO REQUERIMIENTO 3 ♦♦♦\n\n");
        resultsView.append(
                "® Proyectos de apartamentos o aparta-estudios no pagados, o pagados parcialmente que dentro de\n    sus compras tengan material de construcción importado y que no se entreguen acabados ®\n\n");
        resultsView.append("CLASIFICACION\t" + "ID_PROYECTO\t\t" + "PAGADO\n");
        for (Request3 req3 : req3s) {
            resultsView.append(req3.toString() + "\n");
        }
    }
}