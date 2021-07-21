package views;
import model.Presupuesto;
public class View {
   public static void main(String[] args){
    Presupuesto ResultadoInversion3=new Presupuesto();
    System.out.println(ResultadoInversion3.compararPresupuestos(1,2000000,0.9));
    Presupuesto ResultadoInversion=new Presupuesto();
    System.out.println(ResultadoInversion.compararPresupuestos(24,2000000,5));
    Presupuesto ResultadoInversion2=new Presupuesto();
    System.out.println(ResultadoInversion2.compararPresupuestos(1,1000000,1));
    }
}