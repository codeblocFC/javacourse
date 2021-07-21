package model;
public class Presupuesto {
    private int pTiempo;
    private double pMonto;
    private double pInteres;
    private double respuesta;
    
    public Presupuesto() {
        super();
        pTiempo = 0;
        pMonto = 0;
        pInteres = 0;
        respuesta=0;
    }
    //comentar
    public double getinteresSimple(int pTiempo,double pMonto,double pInteres){
        return pMonto*pInteres*pTiempo;
    }

    public double getinteresCompuesto(int pTiempo,double pMonto,double pInteres){
        return pMonto*(Math.pow((1+pInteres),pTiempo)-1);
    }
    
    public boolean verificarRespuesta(){
        if (respuesta==0){
        return false;
        }
        return true;
    }

    public String compararPresupuestos(int pTiempo,double pMonto,double pInteres) {
        respuesta=getinteresCompuesto(pTiempo,pMonto,pInteres)-getinteresSimple(pTiempo,pMonto,pInteres);
        if (verificarRespuesta()){
            return "La diferencia en el total de intereses generados para el proyecto, si escogemos entre evaluarlo a una tasa de interés Compuesto y evaluarlo a una tasa de interés Simple, asciende a la cifra de: $ " + respuesta;
        }
        else {
            return "Faltan datos para calcular la diferencia en el total de intereses generados para el proyecto.";
        }
    }
}