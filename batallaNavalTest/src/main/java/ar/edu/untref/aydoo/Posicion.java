package ar.edu.untref.aydoo;

public class Posicion {

    int fila;
    int columna;
    boolean lleno = false;
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

    public void ocuparPosicion(){
        this.lleno = true;
    }

    public boolean posicionLlena(){
        return lleno;
    }

    //Auxiliares para despues borrar los métodos de posicion
    public void llenarContenido(ParteDeBarco parteDeBarco){
        contenido = parteDeBarco;
    }

    public boolean contenidoEstaVacio(){
        return contenido == null;
    }


}
