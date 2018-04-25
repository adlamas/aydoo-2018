package ar.edu.untref.aydoo;

import java.util.Calendar;

public class Suscripcion {

    Cliente cliente;
    Periodico productoPeriodico;
    Calendar fecha;

    public Suscripcion(Cliente cliente, Periodico productoPeriodico, Calendar fecha) {
        this.cliente = cliente;
        this.productoPeriodico = productoPeriodico;
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Periodico getProductoPeriodico() {
        return productoPeriodico;
    }

    public int obtenerDia(){
        return fecha.get(Calendar.DAY_OF_MONTH);
    }
    public int obtenerMes(){
        return fecha.get(Calendar.MONTH);
    }

    public int obtenerAnio(){
        return fecha.get(Calendar.YEAR);
    }
}
