package ar.edu.untref.aydoo;

public class Barco {

    Orientacion orientacion;
    int longitud;
    Posicion posiciones[];

    public Barco( int longitud, Orientacion orientacion){
        this.orientacion = orientacion;
        this.longitud = longitud;
        posiciones = new Posicion[longitud];
    }

    public void llenarPosiciones(Posicion posicionInicial){
        if(this.getOrientacion() == Orientacion.HORIZONTAL){
            llenarPosicionesHorizontales(posicionInicial);
        }else if(this.getOrientacion() == Orientacion.VERTICAL){
            llenarPosicionesVerticales(posicionInicial);
        }
    }

    private void llenarPosicionesHorizontales(Posicion posIni){
        for(int i = 0; i < longitud; i++){
            posiciones[i] = new Posicion(posIni.getFila(),posIni.getColumna() + i);
        }
    }

    private void llenarPosicionesVerticales( Posicion posIni){
        for(int i = 0; i < longitud; i++){
            posiciones[i] = new Posicion(posIni.getFila() + i,posIni.getColumna() );
        }
    }

    public Posicion obtenerPosicionDeBarco(int indice){
        return this.posiciones[indice];
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    public Posicion[] getPosiciones() {
        return posiciones;
    }

    public  int obtenerLongitud(){
        return longitud;
    }
}
