package ar.edu.untref.aydoo;

import java.util.Calendar;

public class Compra {

    Cliente comprador;
    Producto productoComprado;
    Calendar fecha;

    public Compra(Cliente cliente, Producto producto, Calendar fecha){
        this.comprador = cliente;
        this.productoComprado = producto;
        this.fecha = fecha;
    }

    public Cliente obtenerComprador(){
        return comprador;
    }

    public Producto obtenerProducto() {
        return productoComprado;
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
