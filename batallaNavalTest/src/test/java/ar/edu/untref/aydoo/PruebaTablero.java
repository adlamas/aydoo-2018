package ar.edu.untref.aydoo;

import cucumber.api.java.cs.A;
import org.junit.Assert;
import org.junit.Test;


public class PruebaTablero {

    @Test
    public void pruebaDispararATableroVacioDevuelveAgua(){
        Tablero tablero = new Tablero();
        ResultadoDeDisparo resultadoDisparo = tablero.recibirDisparo(new Posicion(1,1));

        Assert.assertEquals(ResultadoDeDisparo.AGUA, resultadoDisparo);
    }

    @Test
    public void crearYPonerBarcoDeLongUnoEnPosicionUnoUno() throws Exception{
        Tablero tablero = new Tablero();
        Posicion posicionInicial = new Posicion(1,1);
        Barco miBarco = new Barco(1,Orientacion.HORIZONTAL);

       tablero.agregarBarco(miBarco, posicionInicial);
       Assert.assertEquals(miBarco, tablero.obtenerBarco(0));
    }

    @Test
    public void ponerBarcoYTraerSusPosiciones() throws Exception{
        Tablero tablero = new Tablero();
        Posicion posicionInicial = new Posicion(2,2);
        Barco miBarco = new Barco(2,Orientacion.VERTICAL);

        tablero.agregarBarco(miBarco, posicionInicial);
        Posicion posicionesDelBarcoYaAgregado[] = miBarco.getPosiciones();

        Assert.assertEquals(2,posicionesDelBarcoYaAgregado[0].getFila());
        Assert.assertEquals(2,posicionesDelBarcoYaAgregado[0].getColumna());
        Assert.assertEquals(3,posicionesDelBarcoYaAgregado[1].getFila());
        Assert.assertEquals(2,posicionesDelBarcoYaAgregado[1].getColumna());
    }

    @Test //No pasa aún
    public void ponerUnBarcoEncimaDeOtroEnLaMismaPosicionYQueTireUnaExcepcion() throws Exception{

    }

    @Test
    public void llenarPosicionesDeBarcoLongitudTres(){


    }

    @Test
    public void obtenerPosicionesQueOcupariaUnBarco(){


    }

}
