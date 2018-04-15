package ar.edu.untref.aydoo;
import javafx.geometry.Pos;
import javafx.scene.control.Tab;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.internal.stubbing.answers.ThrowsException;

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
        tablero.ubicarBarcoHorizontalOVertical(new Barco(1, Orientacion.HORIZONTAL)
                ,new Posicion(1,1));

        boolean estadoPosicion = tablero.estadoPosicion(1,1);

        Assert.assertTrue(estadoPosicion);
    }

    @Test (expected = Exception.class)

    public void  ubicarBarcoEncimaDeOtroYQueTireUnaExcepcion() throws Exception {
        Tablero tablero = new Tablero();
        Barco miBarco = new Barco( 2, Orientacion.VERTICAL );
        Barco miSegundoBarco = new Barco( 2, Orientacion.HORIZONTAL );
        Posicion posicionUno = new Posicion(2,2);
        Posicion posicionDos = new Posicion(2,1);

        tablero.ubicarBarcoHorizontalOVertical(miBarco, posicionUno);

        tablero.ubicarBarcoHorizontalOVertical(miSegundoBarco,posicionDos);


    }

    @Test
    public void ubicarBarcoFueraDelTableroYQueTireUnaExcepcion(){

    }

    @Test
    public void dispararABarcoYQueDeTocado(){

    }

    @Test
    public void dispararABarcoYQueDeHundido(){

    }

    @Test
    public void dispararABarcoTocadoYQueDevuelvaAgua(){

    }

}
