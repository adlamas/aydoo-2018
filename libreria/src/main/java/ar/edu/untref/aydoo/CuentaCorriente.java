package ar.edu.untref.aydoo;

import java.util.LinkedList;

public class CuentaCorriente {

    LinkedList<Compra> compras = new LinkedList<Compra>();

    public CuentaCorriente(){

    }

    public void agregarCompra(Compra compra){
        compras.add(compra);
    }

    public Compra devolverCompra(int indice){
        return compras.get(indice);
    }
}
