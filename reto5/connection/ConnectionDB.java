package connection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDB {
    private Connection connect;

    public ConnectionDB(String url) {
        super();
        connectDB(url);
    }

    public ResultSet getRequest1DB() {
        String sql = "SELECT ID_Proyecto, pagado, proveedor, SUM (Cantidad) AS total FROM Compra WHERE Pagado='No' GROUP BY ID_Proyecto HAVING total > 50";
        return executeQuery(sql);
    }

    public ResultSet getRequest2DB() {
        String sql = "SELECT Proyecto.Fecha_Inicio, Tipo.Financiable, Tipo.Estrato, Proyecto.Porcentaje_Cuota_Inicial AS porcentaje FROM Tipo, Proyecto WHERE Proyecto.ID_Tipo=Tipo.ID_Tipo AND Tipo.Estrato>=5 AND Tipo.Financiable=0 AND porcentaje>=0.3 ORDER BY Fecha_Inicio ASC";
        return executeQuery(sql);
    }

    public ResultSet getRequest3DB() {
        String sql = "SELECT proyecto.ID_Proyecto, compra.Pagado, proyecto.Clasificacion FROM materialconstruccion, compra, proyecto WHERE materialconstruccion.ID_materialConstruccion = compra.ID_MaterialConstruccion AND compra.ID_Proyecto = proyecto.ID_Proyecto AND materialconstruccion.Importado='Si' AND (compra.Pagado='Parcialmente' OR compra.Pagado='No') AND (proyecto.clasificacion='Apartamento' OR proyecto.clasificacion='Apartaestudio') AND proyecto.Acabados='No' GROUP BY proyecto.ID_Proyecto ORDER BY proyecto.ID_Proyecto ASC";
        return executeQuery(sql);
    }

    public Connection connectDB(String url) {
        try {
            connect = DriverManager.getConnection(url);
      } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connect;
    }

    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            Statement stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}