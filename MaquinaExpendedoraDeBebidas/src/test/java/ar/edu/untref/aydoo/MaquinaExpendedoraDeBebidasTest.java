package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class MaquinaExpendedoraDeBebidasTest {
    @Test
    public void deberiaHacerCafeConLecheCon10DeAzucar() {
        int cantidadAzucar = 10;
        Vaso unVaso = new Vaso();
        MaquinaExpendedoraDeBebidas maquinaExpendedoraDeBebidas = new MaquinaExpendedoraDeBebidas();

        maquinaExpendedoraDeBebidas.hacerCafeConLecheConNDeAzucar(unVaso, cantidadAzucar);

        Assert.assertEquals(cantidadAzucar, unVaso.getCantidadDeAzucar());
        Assert.assertTrue(unVaso.tieneCafe());
        Assert.assertTrue(unVaso.tieneAzucar());
        Assert.assertFalse(unVaso.tieneTe());
    }

}
