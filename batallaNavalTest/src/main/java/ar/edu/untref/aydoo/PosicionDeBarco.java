package ar.edu.untref.aydoo;

public class PosicionDeBarco extends Posicion {

    boolean tocado = false;
    public PosicionDeBarco( int fila,int columna){
        super(fila,columna);
    }

    public void tocarPosicion(){
        tocado = true;
    }

    public boolean posicionTocada(){
        return tocado;
    }
}
