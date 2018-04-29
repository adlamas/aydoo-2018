package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

public class CuentaCorriente {

    ArrayList<Compra> compras = new ArrayList<Compra>();

    public void agregarCompra(Compra compra){
        compras.add(compra);
    }

    public Compra devolverCompra(int indice){
        return compras.get(indice);
    }

    public int devolverComprasDeMes(Calendar fecha, boolean registro){

        int suma = 0;
        for(int i = 0; i < this.compras.size(); i++){
            if(this.devolverCompra(i).obtenerAnio() == fecha.get(Calendar.YEAR)
                    && this.devolverCompra(i).obtenerMes() == fecha.get(Calendar.MONTH)){
                int precioSinDescuento = this.devolverCompra(i).obtenerProducto().getPrecio();
                suma += hacerDescuentoEnCompraPorRegistro(precioSinDescuento, registro);
            }
        }

        return suma;
    }

    public int hacerDescuentoEnCompraPorRegistro(int precioSinDescuento, boolean registrado){
        if(registrado == true){
            return precioSinDescuento - ((precioSinDescuento * 5 /100));
        }

        return precioSinDescuento;
    }

    public int devolverComprasDeAnio(int anio, boolean registro) {
        int suma = 0;
        for (int i = 0; i < this.compras.size(); i++) {
            if (this.devolverCompra(i).obtenerAnio() == anio) {
                int precioSinDescuento = this.devolverCompra(i).obtenerProducto().getPrecio();
                suma += hacerDescuentoEnCompraPorRegistro(precioSinDescuento, registro);
            }
        }
        return suma;
    }
}
