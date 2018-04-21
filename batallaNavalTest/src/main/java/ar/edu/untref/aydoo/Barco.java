package ar.edu.untref.aydoo;

public class Barco {

    Orientacion orientacion;
    int longitud;
    PosicionDeBarco posiciones[];

    public Barco( int longitud, Orientacion orientacion){
        this.orientacion = orientacion;
        this.longitud = longitud;
        posiciones = new PosicionDeBarco[longitud];
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
            posiciones[i] = new PosicionDeBarco(posIni.getFila(),posIni.getColumna() + i);
        }
    }

    private void llenarPosicionesVerticales( Posicion posIni){
        for(int i = 0; i < longitud; i++){
            posiciones[i] = new PosicionDeBarco(posIni.getFila() + i,posIni.getColumna() );
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

    public ResultadoDeDisparo responderADisparo(Posicion posicionDisparo, int indice){
        this.posiciones[indice].tocarPosicion();
        for(int i = 0; i < longitud; i++){
            if(posiciones[i].posicionTocada() == false ){
                return ResultadoDeDisparo.TOCADO;
            }
        }
        return ResultadoDeDisparo.HUNDIDO;
    }
}
