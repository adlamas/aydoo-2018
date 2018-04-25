package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.LinkedList;

public class CuentaCorriente {

    ArrayList<Compra> compras = new ArrayList<Compra>();

    public CuentaCorriente(){

    }

    public int getCantidadDeCompras(){
        return compras.size();
    }

    public void agregarCompra(Compra compra){
        compras.add(compra);
    }

    public Compra devolverCompra(int indice){
        return compras.get(indice);
    }
}
