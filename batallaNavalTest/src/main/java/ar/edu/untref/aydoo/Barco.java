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
        llenarPosiciones();
    }

    public void llenarPosiciones(){
        if(this.getOrientacion() == Orientacion.HORIZONTAL){
            llenarPosicionesHorizontales();
        }else if(this.getOrientacion() == Orientacion.VERTICAL){
            llenarPosicionesVerticales();
        }
    }

    private void llenarPosicionesHorizontales(){
        for(int i = 1; i < longitud; i++){
            posiciones[i] = new Posicion(this.obtenerPosicionDeBarco(0).getFila(),
                    this.obtenerPosicionDeBarco(0).getColumna() + i);
        }
    }

    private void llenarPosicionesVerticales(){
        for(int i = 1; i < longitud; i++){
            posiciones[i] = new Posicion(this.obtenerPosicionDeBarco(0).getFila() + i,
                    this.obtenerPosicionDeBarco(0).getColumna() );
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
