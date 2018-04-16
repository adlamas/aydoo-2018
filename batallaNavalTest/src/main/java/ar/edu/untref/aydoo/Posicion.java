package ar.edu.untref.aydoo;

import com.sun.org.apache.xpath.internal.operations.Or;

public class Posicion {

    int fila;
    int columna;
    boolean lleno = false;
    Orientacion orientacion;

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

    public void setOrientacion(Orientacion orientacion){
        this.orientacion = orientacion;
    }
}
