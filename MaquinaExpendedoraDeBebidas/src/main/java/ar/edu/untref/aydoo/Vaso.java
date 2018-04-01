package ar.edu.untref.aydoo;
import java.util.LinkedList;

public class Vaso {

    private int cantidadDeAzucar;
    private LinkedList<String> bebidas = new LinkedList<String>();

    public int getCantidadDeAzucar(){
        return cantidadDeAzucar;
    }

    public void ponerAzucar(int CucharadasDeAzucar){
        this.cantidadDeAzucar = CucharadasDeAzucar;
    }

    public boolean tieneCafe(){
        return this.bebidas.contains("Cafe");
    }

    public boolean tieneTe(){
        return this.bebidas.contains("Te");
    }

    public boolean tieneAzucar(){
        return this.bebidas.contains("Leche");
    }

    public void aniadirSustancia(String bebida){
        this.bebidas.add(bebida);
    }
}
