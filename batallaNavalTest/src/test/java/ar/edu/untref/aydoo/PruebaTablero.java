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
    public void pruebaUbicarBarcoHorizontalmenteYQueLaPosicionSeLLene() throws Exception{
        Tablero tablero = new Tablero();
        tablero.ubicarBarcoYAniadirSusPosicionesAlTablero(new Barco(3)
                ,new Posicion(1,1), Orientacion.HORIZONTAL);

        Assert.assertEquals(false,tablero.posicionVacia(1,1));
    }

    @Test
    public void ubicarUnBarcoEnLaPosicionUnoUnoHorizontalmenteYQueElTableroLoSepa()
            throws Exception{
        Tablero tablero = new Tablero();
        Barco barco = new Barco(1);
        Posicion posicion = new Posicion(1,1);
        tablero.ubicarBarcoYAniadirSusPosicionesAlTablero(barco,posicion, Orientacion.HORIZONTAL);

        boolean estadoPosicion = tablero.posicionVacia(1,1);
        Assert.assertEquals(false, estadoPosicion);
    }

    @Test (expected = Exception.class)
    public void  ubicarBarcoEncimaDeOtroYQueTireUnaExcepcion() throws Exception {
        Tablero tablero = new Tablero();
        Barco miBarco = new Barco( 2);
        Barco miSegundoBarco = new Barco( 2);
        Posicion posicionUno = new Posicion(2,2);
        Posicion posicionDos = new Posicion(2,1);

        tablero.ubicarBarcoYAniadirSusPosicionesAlTablero(miBarco, posicionUno, Orientacion.VERTICAL);
        tablero.ubicarBarcoYAniadirSusPosicionesAlTablero(miSegundoBarco,posicionDos, Orientacion.HORIZONTAL);

    }

    @Test (expected = Exception.class)
    public void ubicarBarcoFueraDelTableroYQueTireUnaExcepcion() throws Exception{
        Tablero tablero = new Tablero();
        Barco miBarco = new Barco( 2);
        Posicion posicionUno = new Posicion(8,9);

        tablero.ubicarBarcoYAniadirSusPosicionesAlTablero(miBarco, posicionUno, Orientacion.HORIZONTAL );

    }

    @Test
    public void insertoUnBarcoYSusPartesSeInsertanEnLasPosicionesDelTableroIndicadas()
            throws Exception
    {

        Tablero tablero = new Tablero();
        Barco barco = new Barco(3);
        Posicion posicion = new Posicion(2,2);

        tablero.ubicarBarcoYAniadirSusPosicionesAlTablero(barco, posicion, Orientacion.VERTICAL);
        ParteDeBarco partePosDosDos = tablero.obtenerPosicion(2,2).obtenerContenido();
        ParteDeBarco partePosTresDos = tablero.obtenerPosicion(3,2).obtenerContenido();
        ParteDeBarco partePosCuatroDos = tablero.obtenerPosicion(4,2).obtenerContenido();
        ParteDeBarco partePosCincoDos = tablero.obtenerPosicion(5,2).obtenerContenido();
        ParteDeBarco partePosDosTres = tablero.obtenerPosicion(2,3).obtenerContenido();


        Assert.assertNotNull(partePosDosDos);
        Assert.assertNotNull(partePosTresDos);
        Assert.assertNotNull(partePosCuatroDos);
        Assert.assertNull(partePosCincoDos);
        Assert.assertNull(partePosDosTres);
    }

   

    @Test
    public void dispararABarcoYQueDeHundido(){

    }

    @Test
    public void dispararABarcoTocadoYQueDevuelvaAgua(){

    }

}