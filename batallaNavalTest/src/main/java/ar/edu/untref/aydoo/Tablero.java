package ar.edu.untref.aydoo;
import java.util.Iterator;
import java.util.LinkedList;

public class Tablero {

    private LinkedList<Barco> barcos = new LinkedList<Barco>();


    public ResultadoDeDisparo recibirDisparo(Posicion posicion)
    {
        return ResultadoDeDisparo.AGUA;
    }

    public void agregarBarco(Barco mibarco){
        barcos.add(mibarco);
        mibarco.llenarPosiciones();
    }

    public Barco obtenerBarco(int indice){
        return this.barcos.get(indice);
    }

}
