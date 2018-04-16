package ar.edu.untref.aydoo;

import java.util.LinkedList;

public class Tablero {

    private Posicion posiciones[][] = new Posicion[10][10];
    private LinkedList<Barco> barcos = new LinkedList<Barco>();

    public Tablero(){
        for(int i = 0; i < posiciones.length; i++){
            for(int j = 0; j < posiciones[i].length; j++){
                posiciones[i][j] = new Posicion(i,j);
            }
        }
    }

    public ResultadoDeDisparo recibirDisparo(Posicion posicion){

        if(posiciones[posicion.getFila()][posicion.getColumna()].saberSiLaPosicionTieneAlgo() == true)
        {
            return null;
        }
        return ResultadoDeDisparo.AGUA;
    }

    public void ubicarBarcoHorizontalOVertical(Barco barco, Posicion posicionInicial) throws Exception {

        verificarQueLasPosicionesAlPonerUnBarcoSeanLegitimas(barco, posicionInicial);
        this.posiciones[posicionInicial.getFila()][posicionInicial.getColumna()].ocuparPosicion();

        if(barco.getOrientacion() == Orientacion.HORIZONTAL){
            ubicarBarcoHorizontal(barco, posicionInicial);
        }
        else{
            ubicarBarcoVertical(barco,posicionInicial);
        }

    }

    public void ubicarBarcoHorizontal(Barco barco, Posicion posicionInicial){
        for(int i = 1; i < barco.getLongitud(); i++){
            this.posiciones[posicionInicial.getFila()][posicionInicial.getColumna() + i].ocuparPosicion();
        }
    }
    public void ubicarBarcoVertical(Barco barco, Posicion posicionInicial){
        for(int i = 1; i < barco.getLongitud(); i++){
            this.posiciones[posicionInicial.getFila()+ i][posicionInicial.getColumna()].ocuparPosicion();
        }
    }


    private void verificarQueLasPosicionesAlPonerUnBarcoSeanLegitimas(Barco barco, Posicion posicionInicial)
            throws Exception
    {
        if(barco.getOrientacion() == Orientacion.HORIZONTAL){
            for(int i = 0; i < barco.longitud; i++){
                if(this.posiciones[posicionInicial.getFila()][posicionInicial.getColumna() + i].saberSiLaPosicionTieneAlgo() == true){
                    throw new Exception("Una posicion ya esta llena, no podes meter un barco ahi");
                }
            }
        }
        else{
            for(int i = 0; i < barco.longitud; i++){
                if(this.posiciones[posicionInicial.getFila() + i][posicionInicial.getColumna()].saberSiLaPosicionTieneAlgo() == true){
                    throw new Exception("Una posicion ya esta llena, no podes meter un barco ahi");
                }
            }
        }
    }

    public boolean estadoPosicion(int fila, int columna){
        return posiciones[fila][columna].saberSiLaPosicionTieneAlgo();
    }
}
