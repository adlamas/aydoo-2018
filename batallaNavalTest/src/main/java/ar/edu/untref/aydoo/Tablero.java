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

        if(posiciones[posicion.getFila()][posicion.getColumna()].contenidoEstaVacio() == false)
        {
            return null;
        }
        return ResultadoDeDisparo.AGUA;
    }

    public void ubicarBarcoYAniadirSusPosicionesAlTablero(Barco barco, Posicion posicionInicial,
          Orientacion Orientacion) throws Exception
    {

        verificarQueLasPosicionesAlPonerUnBarcoSeanLegitimas(barco, posicionInicial, Orientacion);
        this.posiciones[posicionInicial.getFila()][posicionInicial.getColumna()]
                .llenarContenido(barco.getParteDelBarco(0));

        if(Orientacion == Orientacion.HORIZONTAL){
            ubicarBarcoHorizontal(barco, posicionInicial);
        }
        else{
            ubicarBarcoVertical(barco,posicionInicial);
        }

        this.barcos.add(barco);

    }

    private void ubicarBarcoHorizontal(Barco barco, Posicion posicionInicial){

        for(int i = 1; i < barco.getLongitud(); i++){
            this.posiciones[posicionInicial.getFila()][posicionInicial.getColumna() + i]
                    .llenarContenido(barco.getParteDelBarco(i));
        }
    }

    private void ubicarBarcoVertical(Barco barco, Posicion posicionInicial){
        for(int i = 1; i < barco.getLongitud(); i++){
            this.posiciones[posicionInicial.getFila() + i][posicionInicial.getColumna()]
                    .llenarContenido(barco.getParteDelBarco(i));
        }
    }

    public void verificarQueLasPosicionesAlPonerUnBarcoSeanLegitimas(Barco barco,
       Posicion posicionInicial, Orientacion orientacion) throws Exception
    {
        if(orientacion == Orientacion.HORIZONTAL){
            verificacionPosicionesHorizontales(barco,  posicionInicial);
        }
        else{
            verificacionPosicionesVerticales(barco,  posicionInicial);
        }
    }

    private void verificacionPosicionesHorizontales(Barco barco, Posicion posicionInicial)
            throws Exception
    {
        for(int i = 0; i < barco.longitud; i++){
            if(this.posiciones[posicionInicial.getFila()][posicionInicial.getColumna() + i]
                    .contenidoEstaVacio() == false){
                throw new Exception("Una posicion ya esta llena, no podes meter un barco ahi");
            }
        }
    }

    private void verificacionPosicionesVerticales(Barco barco, Posicion posicionInicial)
            throws Exception
    {
        for(int i = 0; i < barco.longitud; i++){
            if(this.posiciones[posicionInicial.getFila() + i][posicionInicial.getColumna()]
                    .contenidoEstaVacio() == false){
                throw new Exception("Una posicion ya esta llena, no podes meter un barco ahi");
            }
        }
    }

    public Posicion obtenerPosicion(int fila, int columna){
        return this.posiciones[fila][columna];
    }

    public boolean posicionVacia(int fila, int columna){
        return posiciones[fila][columna].contenidoEstaVacio();
    }
}
