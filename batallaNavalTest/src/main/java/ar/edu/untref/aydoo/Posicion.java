package ar.edu.untref.aydoo;

public class Posicion {

    int fila;
    int columna;
    boolean lleno = false;

    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila(){
        return fila;
    }

    public  int getColumna(){
        return  columna;
    }

    public void ocuparPosicion(){
        this.lleno = true;
    }

    public boolean saberSiLaPosicionTieneAlgo(){
        return lleno;
    }
}
