package ar.edu.untref.aydoo;
import javafx.geometry.Pos;
import javafx.scene.control.Tab;
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
    public void ubicarUnBarcoEnLaPosicionUnoUnoHorizontalmenteYQueElTableroLoSepa(){
        Tablero tablero = new Tablero();
        tablero.ubicarBarcoHorizontalOVertical(new Barco(1, Orientacion.HORIZONTAL)
                ,new Posicion(1,1));

        boolean estadoPosicion = tablero.estadoPosicion(1,1);

        Assert.assertTrue(estadoPosicion);
    }

}
