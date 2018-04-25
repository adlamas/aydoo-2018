package ar.edu.untref.aydoo;


import cucumber.api.java.ca.Cal;
import org.junit.Assert;
import org.junit.Test;
import java.util.Calendar;


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

    @Test
    public void AgregarProductosACuentaCorrienteYQueQueden(){

        CuentaCorriente Cuenta = new CuentaCorriente();
        Producto Maestria = new Producto(500);
        Producto cuaderno = new Producto(50);

        Cuenta.agregarProducto(Maestria);
        Cuenta.agregarProducto(cuaderno);

        Assert.assertEquals(Maestria, Cuenta.devolverProducto(0));
        Assert.assertEquals(cuaderno, Cuenta.devolverProducto(1));

    }

    @Test
    public void CrearProductosYDevolverComponentes(){

        Periodico periodico = new Periodico(500 , 1);
        ArtLibreria artLibreria = new ArtLibreria(400, 15);

        int periodicidad = periodico.getPeriodicidad();
        int IVA = artLibreria.getIVA();

        Assert.assertEquals(1, periodicidad);
        Assert.assertEquals(15, IVA);
        Assert.assertEquals(500,periodico.getPrecio());
        Assert.assertEquals(400,artLibreria.getPrecio());

    }

    @Test
    public void clienteRealizaUnaCompraDeUnProducto(){

        Cliente cliente = new Cliente();
        Producto producto = new Producto(250);

        Calendar ahoraCal = Calendar.getInstance();
        ahoraCal.set(2007,1,13);
        Compra compra = new Compra(cliente,producto, ahoraCal);

        Assert.assertEquals(cliente, compra.obtenerComprador());
        Assert.assertEquals(producto, compra.obtenerProducto());
        Assert.assertEquals(13, compra.obtenerDia());
        Assert.assertEquals(1, compra.obtenerMes());
        Assert.assertEquals(2007, compra.obtenerAnio());

    }

    @Test
    public void realizarSuscripcionYObtenerSusDatos(){
        Cliente cliente = new Cliente();
        Periodico periodicoMensual = new Periodico(650, 2);
        Calendar fecha = Calendar.getInstance();
        fecha.set(2009,3,15);

        Suscripcion suscripcionPeriodicoMensual = new Suscripcion(cliente,periodicoMensual, fecha);

        Assert.assertEquals(cliente,suscripcionPeriodicoMensual.getCliente());
        Assert.assertEquals(periodicoMensual,suscripcionPeriodicoMensual.getProductoPeriodico());
        Assert.assertEquals(15, suscripcionPeriodicoMensual.obtenerDia());
        Assert.assertEquals(3, suscripcionPeriodicoMensual.obtenerMes());
        Assert.assertEquals(2009, suscripcionPeriodicoMensual.obtenerAnio());


    }

}
