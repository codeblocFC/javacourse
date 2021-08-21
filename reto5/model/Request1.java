package model;

public class Request1 {
    private int total;
    private int idProyecto;
    private String pagado;
    private String proveedor;

    public Request1() {
        super();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getPagado() {
        return pagado;
    }

    public void setPagado(String pagado) {
        this.pagado = pagado;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        String output = "";
        output += getIdProyecto();
        output += "\t\t";
        output += getPagado();
        output += "\t\t";
        output += getProveedor();
        if (getProveedor().length() < 10) {
            output += "\t\t";
        } else {
            output += "\t";
        }
        output += getTotal();

        return output;
    }
}