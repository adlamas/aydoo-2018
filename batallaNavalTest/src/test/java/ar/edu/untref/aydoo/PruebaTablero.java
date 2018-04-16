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
    public void ubicarUnBarcoEnLaPosicionUnoUnoHorizontalmenteYQueElTableroLoSepa() throws Exception{
        Tablero tablero = new Tablero();
        tablero.ubicarBarcoHorizontalOVertical(new Barco(1)
                ,new Posicion(1,1), Orientacion.HORIZONTAL);

        boolean estadoPosicion = tablero.estadoPosicion(1,1);

        Assert.assertTrue(estadoPosicion);
    }

    @Test (expected = Exception.class)
    public void  ubicarBarcoEncimaDeOtroYQueTireUnaExcepcion() throws Exception {
        Tablero tablero = new Tablero();
        Barco miBarco = new Barco( 2);
        Barco miSegundoBarco = new Barco( 2);
        Posicion posicionUno = new Posicion(2,2);
        Posicion posicionDos = new Posicion(2,1);

        tablero.ubicarBarcoHorizontalOVertical(miBarco, posicionUno, Orientacion.VERTICAL);
        tablero.ubicarBarcoHorizontalOVertical(miSegundoBarco,posicionDos, Orientacion.HORIZONTAL);

    }

    @Test (expected = Exception.class)
    public void ubicarBarcoFueraDelTableroYQueTireUnaExcepcion() throws Exception{
        Tablero tablero = new Tablero();
        Barco miBarco = new Barco( 2);
        Posicion posicionUno = new Posicion(8,9);

        tablero.ubicarBarcoHorizontalOVertical(miBarco, posicionUno, Orientacion.HORIZONTAL );

    }

    @Test
    public void dispararABarcoYQueDeTocado() throws Exception{
        Tablero tablero = new Tablero();
        Barco miBarco = new Barco( 2);
        Posicion posicionUno = new Posicion(2,2);

        tablero.ubicarBarcoHorizontalOVertical(miBarco, posicionUno, Orientacion.HORIZONTAL );
        ResultadoDeDisparo resultadoDisparo = tablero.recibirDisparo(new Posicion(2,2));

        Assert.assertEquals(resultadoDisparo,ResultadoDeDisparo.TOCADO);
    }

    @Test
    public void dispararABarcoYQueDeHundido(){

    }

    @Test
    public void dispararABarcoTocadoYQueDevuelvaAgua(){

    }

}
