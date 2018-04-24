package ar.edu.untref.aydoo;

import java.util.LinkedList;

public class CuentaCorriente {

    LinkedList<Producto> productos = new LinkedList<Producto>();

    public CuentaCorriente(){

    }

    public void agregarProducto(Producto producto){
        productos.add(producto);
    }

    public Producto devolverProducto(int indice){
        return productos.get(indice);
    }
}
