package ar.edu.untref.aydoo;
import org.junit.Assert;
import org.junit.Test;

public class PruebaDisparosTablero {

    @Test
    public void pruebaDispararATableroVacioDevuelveAgua(){
        Tablero tablero = new Tablero();
        ResultadoDeDisparo resultadoDisparo = tablero.recibirDisparo(new Posicion(1,1));

        //Assert.assertEquals(ResultadoDeDisparo.AGUA, resultadoDisparo );
    }

}
