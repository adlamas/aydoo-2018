package ar.edu.untref.aydoo;

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
    public void crearYPonerBarcoDeLongUnoEnPosicionUnoUnoHorizontalmente(){
        Tablero tablero = new Tablero();
        Posicion posicionInicial = new Posicion(1,1);
        Barco miBarco = new Barco(1,posicionInicial,Orientacion.HORIZONTAL);

       tablero.agregarBarco(miBarco);
       Assert.assertEquals(miBarco, tablero.obtenerBarco(0));
    }

    @Test (expected = Exception.class)
    public void ponerUnBarcoEncimaDeOtroEnLaMismaPosicionYQueTireUnaExcepcion() throws Exception{
        Tablero tablero = new Tablero();
        Posicion posicionInicial = new Posicion(1,1);
        Barco miBarco = new Barco(1,posicionInicial,Orientacion.HORIZONTAL);
        Barco miBarco_2 = new Barco(1,posicionInicial,Orientacion.HORIZONTAL);

        try{
            tablero.agregarBarco(miBarco);
            tablero.agregarBarco(miBarco_2);
        }catch(Exception e){
            throw  new Exception("No podes meter un barco arriba del otro");
        }
    }

    @Test //Este viene antes que el de arriba
    public void llenarPosicionesDeBarcoLongitudTres(){
        Posicion posicionInicial = new Posicion(1,1);
        Barco barco = new Barco(3,posicionInicial,Orientacion.HORIZONTAL);

        Assert.assertEquals(posicionInicial,barco.obtenerPosicionDeBarco(0));

        Assert.assertEquals(1, barco.obtenerPosicionDeBarco(1).getFila());
        Assert.assertEquals(2, barco.obtenerPosicionDeBarco(1).getColumna());

        Assert.assertEquals(1, barco.obtenerPosicionDeBarco(2).getFila());
        Assert.assertEquals(3, barco.obtenerPosicionDeBarco(2).getColumna());
    }

}
