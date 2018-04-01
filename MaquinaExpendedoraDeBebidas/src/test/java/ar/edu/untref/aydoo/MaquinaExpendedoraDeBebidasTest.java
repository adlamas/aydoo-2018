package ar.edu.untref.aydoo;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class MaquinaExpendedoraDeBebidasTest {


    //public void deberiaHacerCafeConLecheCon10DeAzucar()

    @Test
    public void deberiaHacerCafeConLecheCon10DeAzucar()
    {
        int cantidadAzucar = 10;
        Vaso unVaso = new Vaso();
        MaquinaExpendedoraDeBebidas maquinaExpendedoraDeBebidas = new MaquinaExpendedoraDeBebidas();

        maquinaExpendedoraDeBebidas.hacerCafeConLecheConNDeAzucar(unVaso, cantidadAzucar);

        Assert.assertEquals(cantidadAzucar, unVaso.getCantidadDeAzucar());
        Assert.assertTrue(unVaso.tieneCafe());
        Assert.assertTrue(unVaso.tieneAzucar());
        Assert.assertFalse(unVaso.tieneTe());
    }

    @Test
    public void deberiaHacerTeConLecheCon0DeAzucar() {

        int cantidadAzucar = 0;
        Vaso unVaso = new Vaso();
        MaquinaExpendedoraDeBebidas maquinaExpendedoraDeBebidas = new MaquinaExpendedoraDeBebidas();

        maquinaExpendedoraDeBebidas.hacerTeConLecheConNDeAzucar(unVaso, cantidadAzucar);

        Assert.assertEquals(cantidadAzucar, unVaso.getCantidadDeAzucar());
        Assert.assertFalse(unVaso.tieneCafe());
        Assert.assertFalse(unVaso.tieneAzucar());
        Assert.assertTrue(unVaso.tieneTe());
    }

}
