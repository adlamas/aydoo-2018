package ar.edu.untref.aydoo;

public class Cliente {

    private static int listaID = 1;
    private int id_cliente;

    public Cliente(){
        id_cliente = listaID;
        listaID++;
    }

    public int obtenerID(){
        return id_cliente;
    }
}
