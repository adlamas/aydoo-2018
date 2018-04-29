package ar.edu.untref.aydoo;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class Libreria {


    private LinkedList<Cliente> clientes = new LinkedList<Cliente>();

    public int cobrarMes(Calendar fecha, Cliente cliente){
        return cliente.obtenerTotalDeMes(fecha);
    }


    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public int cobrarAnio(int anio,Cliente cliente){
        return cliente.devolverTotalAnio(anio);
    }

    public int cobrarMesAClientesRegistrados(Calendar fechaAVer) {

        int suma = 0;

        for(int i = 0; i < clientes.size(); i++){
            if(clientes.get(i).clienteRegistrado() == true){
                suma += clientes.get(i).obtenerTotalDeMes(fechaAVer);
            }
        }

        return suma;
    }
}
