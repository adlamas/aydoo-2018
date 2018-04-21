package ar.edu.untref.aydoo;
import java.util.ArrayList;
import java.util.Iterator;


public class Tablero {

    private ArrayList<Barco> barcos = new ArrayList<Barco>();
    private Iterator iterador = barcos.listIterator();
    int filasTotales;
    int columnasTotales;


    public ResultadoDeDisparo recibirDisparo(Posicion posicion)
    {
        return ResultadoDeDisparo.AGUA;
    }

    public void agregarBarco(Barco mibarco, Posicion posicionInicial) throws ExcepcionPosicionOcupada{

        this.verificarQueLasPosicionesQueSeanValidas(mibarco,posicionInicial);
        mibarco.llenarPosiciones(posicionInicial);
        barcos.add(mibarco);

    }

    public Barco obtenerBarco(int indice){
        return this.barcos.get(indice);
    }


    public void verificarQueLasPosicionesQueSeanValidas(Barco barcoNuevo, Posicion posIni) throws ExcepcionPosicionOcupada{

        Posicion posicionesDeBarcoQueOcuparia[] = calcularPosicionesQueOcupariaUnBarco(barcoNuevo, posIni);
        for (int i = 0; i < barcos.size(); i++) {
            Posicion posicionesQueOcupaCadaBarcoEnElTablero[] = barcos.get(i).getPosiciones();
            for(int j = 0; j < barcoNuevo.obtenerLongitud(); j++){
                for(int h = 0; h < posicionesQueOcupaCadaBarcoEnElTablero.length; h++){
                    if(
                            posicionesDeBarcoQueOcuparia[j].getFila() ==
                            posicionesQueOcupaCadaBarcoEnElTablero[h].getFila()
                            &&
                            posicionesDeBarcoQueOcuparia[j].getColumna() ==
                            posicionesQueOcupaCadaBarcoEnElTablero[h].getColumna()
                    )
                    {
                        throw new ExcepcionPosicionOcupada("Esta posicion ya esta siendo ocupada, pone el barco en otro lado");
                    }
                }
            }

        }
    }

    public Posicion[] calcularPosicionesQueOcupariaUnBarco(Barco barco, Posicion posicionInicial)
    {
        Posicion posicionesDeBarcoQueOcuparia[] = new Posicion[barco.obtenerLongitud()];
        for(int i = 0; i < barco.obtenerLongitud(); i++)
        {
            if(barco.getOrientacion() == Orientacion.HORIZONTAL){
                int fila = posicionInicial.getFila();
                int columna = posicionInicial.getColumna() + i;
                posicionesDeBarcoQueOcuparia[i] = new Posicion(fila,columna);
            }
            else if (barco.getOrientacion() == Orientacion.VERTICAL){
                int fila = posicionInicial.getFila() +i;
                int columna = posicionInicial.getColumna();
                posicionesDeBarcoQueOcuparia[i] = new Posicion(fila,columna);
            }

        }
        return posicionesDeBarcoQueOcuparia;
    }

}
