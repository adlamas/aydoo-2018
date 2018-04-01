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
        return false;
    }

    public boolean tieneTe(){

        return false;
    }

    public boolean tieneAzucar(){

        return false;
    }

    public void aniadirSustancia(String bebida){
        this.bebidas.add(bebida);
    }
}
