package ar.edu.untref.aydoo;

public class Posicion {

    int fila;
    int columna;
    ParteDeBarco contenido;

    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila()
    {
        return fila;
    }

    public  int getColumna(){
        return  columna;
    }

    public ParteDeBarco obtenerContenido(){
        return contenido;
    }


}
