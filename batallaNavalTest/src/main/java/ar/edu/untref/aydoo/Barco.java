package ar.edu.untref.aydoo;

public class Barco {

    Orientacion orientacion;
    int longitud;
    Posicion posiciones[];

    public Barco( int longitud, Posicion posInicial, Orientacion orientacion){
        this.orientacion = orientacion;
        this.longitud = longitud;
        posiciones = new Posicion[longitud];
        posiciones[0] = posInicial;
    }
}
