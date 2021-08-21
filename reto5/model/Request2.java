package model;

public class Request2 {
    private int estrato;
    private String fechaInicio;
    private String financiable;
    private double porcentaje;

    public Request2() {
        super();
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFinanciable() {
        return financiable;
    }

    public void setFinanciable(String financiable) {
        this.financiable = financiable;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return estrato + "\t" + fechaInicio + "\t\t" + financiable + "\t\t" + porcentaje;
    }

}