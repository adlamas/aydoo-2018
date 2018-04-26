package ar.edu.untref.aydoo;

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
    public void comprarProductoYAgregarCompraACuentaCorriente(){

        Cliente comprador = new Cliente();
        Producto producto1 = new Producto(400);
        Calendar fecha = Calendar.getInstance();
        fecha.set(2009,3,15);
        Compra compra = comprador.comprarProducto(producto1, fecha);

        Assert.assertEquals(comprador, compra.obtenerComprador());
        Assert.assertEquals(producto1, compra.obtenerProducto());
        Assert.assertEquals(15, compra.obtenerDia());
        Assert.assertEquals(3, compra.obtenerMes());
        Assert.assertEquals(2009, compra.obtenerAnio());
        Assert.assertEquals(compra, comprador.getCuentaCorriente().devolverCompra(0));
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
    public void realizarSuscripcionYObtenerSusDatos(){
        Cliente cliente = new Cliente();
        Periodico periodicoMensual = new Periodico(650, 2);
        Calendar fecha = Calendar.getInstance();
        fecha.set(2009,3,15);

        cliente.suscribirse(periodicoMensual, fecha);

        Assert.assertEquals(650, cliente.obtenerSuscripcion(0)
                .getProductoPeriodico().getPrecio());

        Assert.assertEquals(2, cliente.obtenerSuscripcion(0)
                .getProductoPeriodico().getPeriodicidad());

    }

    @Test
    public void devolverComprasDeUnMes(){

        Cliente comprador = new Cliente();
        Producto producto1 = new Producto(450);
        Producto producto2 = new Producto(600);
        Calendar fecha = Calendar.getInstance();
        fecha.set(2009,3,15);
        comprador.comprarProducto(producto1, fecha);
        fecha.set(2009, 3, 21);
        comprador.comprarProducto(producto2, fecha);

        Assert.assertEquals(1050, comprador.devolverComprasDelMes(fecha, comprador.clienteRegistrado()));

    }

    @Test
    public void devolverComprasDeUnMesConDescuento(){
        Cliente comprador = new Cliente();
        Producto producto1 = new Producto(400);
        Producto producto2 = new Producto(600);
        Calendar fecha = Calendar.getInstance();
        comprador.registrarseEnSistema();
        fecha.set(2009,3,15);
        comprador.comprarProducto(producto1, fecha);
        fecha.set(2009, 3, 21);
        comprador.comprarProducto(producto2, fecha);

        Assert.assertEquals(950, comprador.devolverComprasDelMes(fecha, comprador.clienteRegistrado()));
    }

    @Test
    public void devolverSuscripcionesDeUnCliente(){
        /*Ciertos productos pueden COMPRARSE mientras que las a los periódicos
        hay que SUSCRIBIRSE*/

        Cliente comprador = new Cliente();
        Periodico revistaGente = new Periodico(1100, 1);
        Periodico diarioOLE = new Periodico(850, 1);
        Periodico semanalEconomico = new Periodico(900, 4);

        Calendar fechaRevistaGente = Calendar.getInstance();
        Calendar fechaDiarioOLE = Calendar.getInstance();
        Calendar fechaSemanalEconomico = Calendar.getInstance();

        fechaRevistaGente.set(2009,3,15);
        fechaDiarioOLE.set(2009, 3, 21);
        fechaSemanalEconomico.set(2009, 3, 26);

        comprador.suscribirse(revistaGente, fechaRevistaGente);
        comprador.suscribirse(diarioOLE, fechaDiarioOLE);
        comprador.suscribirse(semanalEconomico,fechaSemanalEconomico);

        Assert.assertEquals(revistaGente, comprador.obtenerSuscripcion(0).productoPeriodico);
        Assert.assertEquals(diarioOLE, comprador.obtenerSuscripcion(1).productoPeriodico);
        Assert.assertEquals(semanalEconomico, comprador.obtenerSuscripcion(2).productoPeriodico);

    }

    @Test
    public void cobrarSuscripcionesDeMes(){

        Libreria libreria = new Libreria();
        Cliente comprador = new Cliente();
        Periodico revistaGente = new Periodico(1100, 1);
        Periodico diarioOLE = new Periodico(850, 1);
        Periodico semanalEconomico = new Periodico(900, 4);

        Calendar fechaRevistaGente = Calendar.getInstance();
        Calendar fechaDiarioOLE = Calendar.getInstance();
        Calendar fechaSemanalEconomico = Calendar.getInstance();

        fechaRevistaGente.set(2009,3,15);
        fechaDiarioOLE.set(2009, 3, 21);
        fechaSemanalEconomico.set(2009, 3, 26);

        comprador.suscribirse(revistaGente, fechaRevistaGente);
        comprador.suscribirse(diarioOLE, fechaDiarioOLE);
        comprador.suscribirse(semanalEconomico,fechaSemanalEconomico);

        libreria.agregarCliente(comprador);

        Calendar fechaAVer = Calendar.getInstance();
        fechaAVer.set(2009,3, 30);

        Assert.assertEquals(2850, comprador.obtenerSuscripcionesDeUnMes(fechaAVer));
    }




}
