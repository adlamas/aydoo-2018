package ar.edu.untref.aydoo;

import cucumber.api.java.cs.A;
import javafx.geometry.Pos;
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
    public void crearYPonerBarcoDeLongUnoEnPosicionUnoUno() throws ExcepcionPosicionOcupada ,ExcepcionBarcoFueraDeLimites{
        Tablero tablero = new Tablero();
        Posicion posicionInicial = new Posicion(1,1);
        Barco miBarco = new Barco(1,Orientacion.HORIZONTAL);

       tablero.agregarBarco(miBarco, posicionInicial);
       Assert.assertEquals(miBarco, tablero.obtenerBarco(0));
    }

    @Test
    public void ponerBarcoYTraerSusPosiciones() throws ExcepcionPosicionOcupada, ExcepcionBarcoFueraDeLimites{
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

    @Test
    public void obtenerPosicionesQueOcupariaUnBarco() throws ExcepcionBarcoFueraDeLimites{
        Tablero tablero = new Tablero();
        Posicion posicionInicial = new Posicion(3,1);
        Barco miBarco = new Barco(2,Orientacion.VERTICAL);
        Posicion posiciones[] = tablero.calcularPosicionesQueOcupariaUnBarco(miBarco, posicionInicial);

        Assert.assertEquals(3,posiciones[0].getFila());
        Assert.assertEquals(1,posiciones[0].getColumna());
        Assert.assertEquals(4,posiciones[1].getFila());
        Assert.assertEquals(1,posiciones[1].getColumna());
    }

    @Test (expected = ExcepcionPosicionOcupada.class)
    public void ponerUnBarcoEncimaDeOtroEnLaMismaPosicionYQueTireUnaExcepcion() throws ExcepcionPosicionOcupada ,ExcepcionBarcoFueraDeLimites{
        Tablero tablero = new Tablero();
        Posicion posicionInicial = new Posicion(1,1);
        Barco miBarco = new Barco(1,Orientacion.VERTICAL);
        Barco miBarco2 = new Barco(1,Orientacion.VERTICAL);

        tablero.agregarBarco(miBarco, posicionInicial);
        tablero.agregarBarco(miBarco2,posicionInicial);
    }

    @Test
    public void ponerDosBarcosYQueNoTireExcepcion() throws ExcepcionPosicionOcupada, ExcepcionBarcoFueraDeLimites{
        Tablero tablero = new Tablero();
        Posicion posicionInicial1 = new Posicion(1,1);
        Posicion posicionInicial2 = new Posicion(1,2);
        Barco miBarco = new Barco(2,Orientacion.VERTICAL);
        Barco miBarco2 = new Barco(2,Orientacion.HORIZONTAL);

        tablero.agregarBarco(miBarco,posicionInicial1);
        tablero.agregarBarco(miBarco,posicionInicial2);
    }

    @Test (expected = ExcepcionBarcoFueraDeLimites.class)
    public void ponerBarcoFueraDeLimitesYQueTireUnaExcepcion() throws ExcepcionPosicionOcupada ,ExcepcionBarcoFueraDeLimites{
        Tablero tablero = new Tablero();
        Posicion posicionInicial1 = new Posicion(9,9);
        Barco miBarco = new Barco(2,Orientacion.VERTICAL);

        tablero.agregarBarco(miBarco, posicionInicial1);
    }

    @Test
    public void dispararATableroYQueDevuelvaAgua(){
        Tablero tablero = new Tablero();
        Posicion posicionDisparo = new Posicion(2,2);
        ResultadoDeDisparo resultadoDeDisparo = tablero.recibirDisparo(posicionDisparo);

        Assert.assertEquals(ResultadoDeDisparo.AGUA, resultadoDeDisparo);
    }

    @Test
    public void dispararABarcoYQueDevuelvaTocado() throws ExcepcionPosicionOcupada ,ExcepcionBarcoFueraDeLimites{
        Tablero tablero = new Tablero();
        Posicion posicionDisparo = new Posicion(2,2);
        Posicion posicionInicial = new Posicion(2,2);
        Barco miBarco = new Barco(2,Orientacion.VERTICAL);
        tablero.agregarBarco(miBarco,posicionInicial);
        ResultadoDeDisparo resultadoDeDisparo = tablero.recibirDisparo(posicionDisparo);

        Assert.assertEquals(ResultadoDeDisparo.TOCADO, resultadoDeDisparo);
    }

    @Test
    public void cantidadDeBarcosAgregadosATablero() throws ExcepcionPosicionOcupada ,ExcepcionBarcoFueraDeLimites{
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(2,2);
        Posicion posicion2 = new Posicion(6,6);
        Posicion posicion3 = new Posicion(3,3);
        Posicion posicion4 = new Posicion(9,9);
        Barco miBarco1 = new Barco(2,Orientacion.VERTICAL);
        Barco miBarco2 = new Barco(2,Orientacion.VERTICAL);
        Barco miBarco3 = new Barco(2,Orientacion.HORIZONTAL);
        Barco miBarco4 = new Barco(1,Orientacion.HORIZONTAL);

        tablero.agregarBarco(miBarco1,posicion1);
        tablero.agregarBarco(miBarco2,posicion2);
        tablero.agregarBarco(miBarco3,posicion3);
        tablero.agregarBarco(miBarco4,posicion4);

        Assert.assertEquals(4,tablero.cantidadDeBarcosAgregados());
    }


}
