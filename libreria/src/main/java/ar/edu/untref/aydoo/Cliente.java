package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Calendar;

public class Cliente {

    CuentaCorriente cuentaCorriente = new CuentaCorriente();
    private Direccion direccion;
    private Registro registroDelSistema = new Registro();
    private ArrayList<Suscripcion> suscripciones = new ArrayList<Suscripcion>();

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void setCuentaCorriente(CuentaCorriente cuenta){
        this.cuentaCorriente = cuenta;
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public Direccion getDireccion() {
        return this.direccion;
    }

    public Compra comprarProducto(Producto producto1, Calendar fecha) {

        Compra compra = new Compra(this, producto1, fecha);
        this.cuentaCorriente.agregarCompra(compra);
        return compra;
    }

    public int devolverComprasDelMes(Calendar fecha, boolean registro){

        int total = 0;
        total = getCuentaCorriente().devolverComprasDeMes(fecha, clienteRegistrado());

        return total;
    }

    public void registrarseEnSistema() {
        this.registroDelSistema.registrarse();
    }

    public boolean clienteRegistrado(){
        return registroDelSistema.estaRegistrado();
    }

    public void suscribirse(Periodico periodicoMensual, Calendar fecha) {
        Suscripcion suscripcionMensual = new Suscripcion(periodicoMensual, fecha);
        this.suscripciones.add(suscripcionMensual);
    }

    public Suscripcion obtenerSuscripcion(int indice){
        return this.suscripciones.get(indice);
    }
}
