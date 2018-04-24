package ar.edu.untref.aydoo;

public class Periodico extends Producto {

    int periodicidad;
    public Periodico(int precio, int peridiocidad){
        super(precio);
        this.periodicidad = peridiocidad;
    }

    public int getPeriodicidad(){
        return periodicidad;
    }
}
