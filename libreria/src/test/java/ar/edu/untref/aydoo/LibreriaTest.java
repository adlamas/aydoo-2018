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
    public void crearUnClienteYUnaCuentaYAsignarCuentaAlCliente(){

        Cliente cliente1 = new Cliente();
        CuentaCorriente cuenta = new CuentaCorriente();
        cliente1.setCuentaCorriente(cuenta);

        Assert.assertEquals(cuenta,cliente1.getCuentaCorriente());
    }

    @Test
    public void asignarDireccionACliente(){

        Cliente cliente = new Cliente();
        Direccion direccion = new Direccion("Calle falsa", 123);
        cliente.setDireccion(direccion);

       Direccion direccionCliente = cliente.getDireccion();
       Assert.assertEquals(direccion,direccionCliente);

    }

}
