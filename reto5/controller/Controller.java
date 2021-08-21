package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConnectionDB;
import model.*;

public class Controller {
    private ArrayList<Request1> req1s;
    private ArrayList<Request2> req2s;
    private ArrayList<Request3> req3s;
    private ConnectionDB connector;

    public Controller(String url) {
        super();
        connector = new ConnectionDB(url);

    }

    public ArrayList<Request1> getReq1s() {
        return req1s;
    }

    public void setReq1s(ArrayList<Request1> req1s) {
        this.req1s = req1s;
    }

    public ArrayList<Request2> getReq2s() {
        return req2s;
    }

    public void setReq2s(ArrayList<Request2> req2s) {
        this.req2s = req2s;
    }

    public ArrayList<Request3> getReq3s() {
        return req3s;
    }

    public void setReq3s(ArrayList<Request3> req3s) {
        this.req3s = req3s;
    }

    public ConnectionDB getConectorDB() {
        return connector;
    }

    public void setConectorDB(ConnectionDB connector) {
        this.connector = connector;
    }

    public ArrayList<Request1> req1() {
        req1s = new ArrayList<>();
        ResultSet rs = connector.getRequest1DB();
        try {
            while (rs.next()) {
                Request1 list1 = new Request1();
                list1.setIdProyecto(rs.getInt("ID_Proyecto"));
                list1.setPagado(rs.getString("pagado"));
                list1.setProveedor(rs.getString("proveedor"));
                list1.setTotal(rs.getInt("total"));

                req1s.add(list1);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return req1s;
    }

    public ArrayList<Request2> req2() {
        req2s = new ArrayList<>();
        ResultSet rs = connector.getRequest2DB();
        try {
            while (rs.next()) {
                Request2 list2 = new Request2();
                list2.setEstrato(rs.getInt("estrato"));
                list2.setFechaInicio(rs.getString("fecha_Inicio"));
                list2.setFinanciable(rs.getString("financiable"));
                list2.setPorcentaje((int) (rs.getDouble("porcentaje") * 100));

                req2s.add(list2);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return req2s;
    }

    public ArrayList<Request3> req3() {
        req3s = new ArrayList<>();
        ResultSet rs = connector.getRequest3DB();
        try {
            while (rs.next()) {
                Request3 list3 = new Request3();
                list3.setClasificacion(rs.getString("clasificacion"));
                list3.setIdProyecto(rs.getInt("ID_Proyecto"));
                list3.setPagado(rs.getString("pagado"));

                req3s.add(list3);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return req3s;
    }
}