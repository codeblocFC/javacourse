package model;

public class Request3 {
    private int idProyecto;
    private String clasificacion;
    private String pagado;

    public Request3() {
        super();
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getPagado() {
        return pagado;
    }

    public void setPagado(String pagado) {
        this.pagado = pagado;
    }

    @Override
    public String toString() {
        return clasificacion + "\t\t" + idProyecto + "\t\t" + pagado;
    }

}