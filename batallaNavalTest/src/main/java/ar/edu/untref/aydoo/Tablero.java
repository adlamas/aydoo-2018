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

    public void agregarBarco(Barco mibarco) throws Exception{

        this.verificarQueLasPosicionesQueSeanValidas(mibarco);
        mibarco.llenarPosiciones();
        barcos.add(mibarco);

    }

    public Barco obtenerBarco(int indice){
        return this.barcos.get(indice);
    }


    public void verificarQueLasPosicionesQueSeanValidas(Barco barco) throws Exception{

        Posicion posicionesDeBarcoQueOcuparia[] = calcularPosicionesQueOcupariaUnBarco(barco);
        for (int i = 0; i < barcos.size(); i++) {
            Posicion posicionesQueOcupaCadaBarco[] = barcos.get(i).getPosiciones();
            for(int j = 0; j < barco.obtenerLongitud(); j++){
                for(int h = 0; h < posicionesQueOcupaCadaBarco.length; h++){
                    if(posicionesDeBarcoQueOcuparia[j].getFila() == posicionesQueOcupaCadaBarco[h].getFila() &&
                        posicionesDeBarcoQueOcuparia[j].getColumna() == posicionesQueOcupaCadaBarco[h].getColumna()){
                        throw new Exception("Posicion ocupada");
                    }
                }
            }

        }
    }

    public Posicion[] calcularPosicionesQueOcupariaUnBarco(Barco barco)
    {
        Posicion posicionesDeBarcoQueOcuparia[] = new Posicion[barco.obtenerLongitud()];
        posicionesDeBarcoQueOcuparia[0] = barco.obtenerPosicionDeBarco(0);
        for(int i = 1; i < barco.obtenerLongitud(); i++)
        {
            if(barco.getOrientacion() == Orientacion.HORIZONTAL){
                int fila = barco.obtenerPosicionDeBarco(0 ).getFila();
                int columna = barco.obtenerPosicionDeBarco(0).getColumna() + i;
                posicionesDeBarcoQueOcuparia[i] = new Posicion(fila,columna);
            }
            else if (barco.getOrientacion() == Orientacion.VERTICAL){
                int fila = barco.obtenerPosicionDeBarco(0 ).getFila() +i;
                int columna = barco.obtenerPosicionDeBarco(0).getColumna();
                posicionesDeBarcoQueOcuparia[i] = new Posicion(fila,columna);
            }

        }
        return posicionesDeBarcoQueOcuparia;
    }

}
