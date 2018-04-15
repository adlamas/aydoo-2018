package ar.edu.untref.aydoo;

public class Tablero {

    private Posicion posiciones[][] = new Posicion[10][10];

    public Tablero(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
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

    public void ubicarBarcoHorizontalOVertical(Barco barco, Posicion posicionInicial)
    {
        this.posiciones[posicionInicial.getFila()][posicionInicial.getColumna()].ocuparPosicion();
        if(barco.getOrientacion() == Orientacion.HORIZONTAL){
            for(int i = 1; i < barco.getLongitud(); i++){
                this.posiciones[posicionInicial.getFila()][posicionInicial.getColumna() + i].ocuparPosicion();
            }
        }
        else
            {
            for(int i = 1; i < barco.getLongitud(); i++){
                this.posiciones[posicionInicial.getFila()+ i][posicionInicial.getColumna()].ocuparPosicion();
            }
        }

    }

    public boolean estadoPosicion(int fila, int columna){
        return posiciones[fila][columna].saberSiLaPosicionTieneAlgo();
    }
}
