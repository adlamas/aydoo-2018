package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class LibreriaTest {

    @Test
    public void crearLibreria(){

        Libreria libreria = new Libreria();

        Assert.assertNotNull(libreria);
    }

    @Test
    public void crearClientesYAsignarlesID(){

        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        Cliente cliente3 = new Cliente();

        Assert.assertEquals(1, cliente1.obtenerID());
        Assert.assertEquals(2, cliente2.obtenerID());
        Assert.assertEquals(3, cliente3.obtenerID());

    }


}
