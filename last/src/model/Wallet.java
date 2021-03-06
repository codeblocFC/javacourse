package model;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;

public class Wallet {

    public static final int CAPACIDAD_MAXIMA = 1000000;

    private int id;
    private int saldo;
    private boolean tieneLimite;
    private int meta;

    /**
     * Listas
     */

    private ArrayList<Transaction> movimientos;

    public Wallet() {
        super();
        saldo = 0;
        tieneLimite = true;
        meta = 0;
        movimientos = new ArrayList<>();
    }

    public ArrayList<Transaction> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<Transaction> movimientos) {
        this.movimientos = movimientos;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public boolean getTieneLimite() {
        return tieneLimite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean establecerMeta(int value) {
        if (value == 0) {
            meta = value;
            return true;
        }
        if (value < 0 || value <= saldo || (value > CAPACIDAD_MAXIMA && tieneLimite)) {
            return false;
        }
        meta = value;
        return true;
    }

    public boolean verificarMeta() {
        if (meta == 0 || saldo < meta) {
            return false;
        }
        return true;
    }

    public void setTieneLimite(boolean newTieneLimite) {
        this.tieneLimite = newTieneLimite;
    }

    public String saveMoney(int value) {
        if (saldo + value > CAPACIDAD_MAXIMA && tieneLimite) {
            return "No se puede superar el limite " + CAPACIDAD_MAXIMA;
        }
        saldo += value; // saldo = saldo + value
        Transaction ingreso = new Transaction(value, "hoy", 1, "Ingreso de dinero");
        movimientos.add(ingreso);
        if (verificarMeta()) {
            System.out.println("Has cumplido la meta!");
        }
        return "Transacci??n exitosa, nuevo saldo " + saldo;
    }

    public String takeMoney(int value) {
        if (saldo >= value) {
            saldo -= value;
            Transaction retiro = new Transaction(value, "hoy", 2, "Retiro de dinero");
            movimientos.add(retiro);
            return "Transacci??n exitosa, nuevo saldo " + saldo;
        }
        return "Saldo insuficiente";
    }

    public String breakLimit() {
        if (!tieneLimite) {
            return "Tu cuenta no tiene limites!";
        }
        if (saldo >= 10000) {
            saldo -= 10000;
            setTieneLimite(false); // tieneLimite = false;
            Transaction limite = new Transaction(10000, "hoy", 2, "Romper limites");
            movimientos.add(limite);
            return "Has roto los limites!";
        }
        return "No tienes saldo suficiente :(";
    }

    public String compararCuenta(Wallet otraWallet) {
        if (saldo == otraWallet.getSaldo()) {
            return "Las cuentas tienen en mismo saldo";
        }
        if (saldo > otraWallet.getSaldo()) {
            return "La primera cuenta es mayor";
        }
        return "La segunda cuenta es mayor";
    }

    public void displayMovimientos() {
        for (Transaction movimiento : movimientos) {
            System.out.println(movimiento);
        }
    }

    public void generarRegistro() {
        try {
            OutputStream ous = new FileOutputStream("./data/trans.properties");
            Properties prop = new Properties();
            int i = 1;
            for (Transaction movimiento : movimientos) {
                System.out.println(movimiento);
                prop.setProperty(i + "", movimiento.toString() + "");
                i++;
            }
            prop.store(ous, null);
            System.out.println(prop);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}