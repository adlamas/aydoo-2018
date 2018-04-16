package ar.edu.untref.aydoo;

public class Barco {

    int longitud;
    Orientacion orientacion;
    Posicion posicionesDelBarco[] = new Posicion[longitud];

    public Barco(int longitud) {
        this.longitud = longitud;

    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    /*public void ubicarseEnTablero(Posicion posicionInicial){
        for(int i = 0; i < longitud; i++){
            if(this.orientacion.getOrientacion() == "horizontal"){

            }
        }
    }*/

    public int getLongitud(){
        return longitud;
    }
}
