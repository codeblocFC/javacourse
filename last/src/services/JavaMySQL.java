package services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import java.sql.Statement;

public class JavaMySQL {

    private Connection connect;
    private String url;
    private String user;
    private String password;

    public JavaMySQL() {
        super();
        loadPropertiesDB();
        connectDB();
    }

    public void connectDB() {
        try {
            connect = DriverManager.getConnection(url, user, password);
            boolean valid = connect.isValid(3600);
            System.out.println(valid ? "Connected" : "Failed");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void loadPropertiesDB() {
        try {
            InputStream ins = new FileInputStream("./data/db.properties");
            Properties prop = new Properties();
            prop.load(ins);
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void insertUser(String nombre) {
        String sql = "INSERT INTO `users` (`name`,`user_status`) VALUES ('" + nombre + "',1)";
        executeInsertStatement(sql);
        insertWallet();

    }

    public void insertWallet() {
        String sql = "INSERT INTO `wallets`(`user_id`) SELECT MAX(id) FROM users";
        executeInsertStatement(sql);
    }

    public void insertTransaction(int id, int type, int value) {
        String sql = "INSERT INTO `transactions`(`saldo`,`transaction_type`,`wallet_id`)" + "VALUES(" + value + ","
                + type + "," + id + ")";
        executeInsertStatement(sql);

    }

    public ResultSet getUserDB() {
        String sql = "SELECT  * FROM users";
        return executeQueryStatemen(sql);
    }

    public ResultSet getWalletUser(int id) {
        String sql = "SELECT * FROM wallets WHERE user_id = " + id;
        return executeQueryStatemen(sql);

    }

    public ResultSet getWalletTransactions(int id) {
        String sql = "SELECT * FROM transactions WHERE wallet_id = " + id;
        return executeQueryStatemen(sql);

    }

    public ResultSet executeQueryStatemen(String sql) {
        ResultSet rs = null;
        try {
            Statement stmt = connect.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void executeInsertStatement(String sql) {
        try {
            Statement stmt = connect.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnect() {
        return connect;
    }

}