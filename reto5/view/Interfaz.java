package view;


import javax.swing.JFrame;

import controller.Controller;



public class Interfaz extends JFrame{

    private RequestPanel requestPanel;
    private ResultsPanel resultsPanel;
    private Controller controller;
    private BackgroundPanel backgroundPanel;
    private BackgroundResults backgroundRP;
    

    public Interfaz() {
        super();
        setSize(616, 720);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("PROYECTOS CONSTRUCCION");
        setLayout(null);

        controller = new Controller("jdbc:sqlite:data/ProyectosConstruccion.db");
        requestPanel = new RequestPanel(this);
        resultsPanel = new ResultsPanel(this);
        backgroundPanel = new BackgroundPanel(this);
        backgroundRP = new BackgroundResults();

        

        add(backgroundPanel);
        add(requestPanel);
        add(backgroundRP);
        

        backgroundPanel.setBounds(0, 0, 600, 200);
        requestPanel.setBounds(0, 201, 600, 50);
        backgroundRP.setBounds(0, 252, 600, 430);
        
        
    }
        
    public void printResults1() {
        add(resultsPanel);
        resultsPanel.setVisible(true);
        resultsPanel.setBounds(0, 252, 600, 430);
        backgroundRP.setVisible(false);
        resultsPanel.printRequest1(controller.req1());
    }

    public void printResults2() {
        add(resultsPanel);
        resultsPanel.setVisible(true);
        resultsPanel.setBounds(0, 252, 600, 430);
        backgroundRP.setVisible(false);
        resultsPanel.printRequest2(controller.req2());
    }

    public void printResults3() {
        add(resultsPanel);
        resultsPanel.setVisible(true);
        resultsPanel.setBounds(0, 252, 600, 430);
        backgroundRP.setVisible(false);
        resultsPanel.printRequest3(controller.req3());
    }

    public void clear() {
        resultsPanel.setVisible(false);
        backgroundRP.setVisible(true);
        
    }

    public static void main(String[] args) throws Exception {
        Interfaz vista = new Interfaz();
        vista.setVisible(true);

    }

}