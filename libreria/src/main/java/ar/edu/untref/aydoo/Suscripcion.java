package ar.edu.untref.aydoo;

import java.util.Calendar;

public class Suscripcion {


    Periodico productoPeriodico;
    Calendar fecha;

    public Suscripcion(Periodico productoPeriodico, Calendar fecha) {

        this.productoPeriodico = productoPeriodico;
        this.fecha = fecha;
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

    public int devolverPrecioDeSuscripcionConDescuento(Suscripcion suscripcion){
        if(suscripcion instanceof SuscripcionAnual){
            int precio = suscripcion.getProductoPeriodico().getPrecio();
            return precio - ((precio * 20) /100);
        }

        return suscripcion.getProductoPeriodico().getPrecio();
    }

}
