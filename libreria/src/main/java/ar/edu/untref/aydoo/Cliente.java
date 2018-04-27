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

    public void suscribirseAnualmente(Periodico periodicoMensual, Calendar fecha){
        SuscripcionAnual suscripcionAnual = new SuscripcionAnual(periodicoMensual, fecha);
        this.suscripciones.add(suscripcionAnual);
    }

    public int obtenerSumaSuscripcionesDeUnMes(Calendar fecha){
        int suma = 0;
        for(int i = 0; i < this.suscripciones.size(); i++){
            if(this.suscripciones.get(i).obtenerAnio() == fecha.get(Calendar.YEAR)
                    && this.suscripciones.get(i).obtenerMes() == fecha.get(Calendar.MONTH)){

                suma += suscripciones.get(i).devolverPrecioDeSuscripcionConDescuento(suscripciones.get(i));
            }
        }
        return suma;
    }

    public int obtenerTotalDeMes(Calendar fechaAVer) {
        return obtenerSumaSuscripcionesDeUnMes(fechaAVer)
                + devolverComprasDelMes(fechaAVer , this.clienteRegistrado());
    }

    public int devolverComprasDelAnio(int anio, boolean clienteRegistrado) {
        int total = 0;
        total = getCuentaCorriente().devolverComprasDeAnio(anio, clienteRegistrado());

        return total;
        }

    public int devolverMontoDeSuscripcionesDelAnio(int anio) {
        int suma = 0;
        for(int i = 0; i < this.suscripciones.size(); i++){
            if(this.suscripciones.get(i).obtenerAnio() == anio){

                suma += (suscripciones.get(i)
                        .devolverPrecioDeSuscripcionConDescuento(suscripciones.get(i)) ) * 12;
            }
        }
        return suma;
    }
}
