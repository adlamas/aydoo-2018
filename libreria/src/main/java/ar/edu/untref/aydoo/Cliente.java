package ar.edu.untref.aydoo;

import java.util.Calendar;

public class Cliente {

    CuentaCorriente cuentaCorriente = new CuentaCorriente();
    private Direccion direccion;

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

    public int devolverComprasDelMes(Calendar fecha){

        int suma = 0;
        for(int i = 0; i < cuentaCorriente.getCantidadDeCompras(); i++){
            if(cuentaCorriente.devolverCompra(i).obtenerAnio() == fecha.get(Calendar.YEAR)
               && cuentaCorriente.devolverCompra(i).obtenerMes() == fecha.get(Calendar.MONTH)){
                suma += cuentaCorriente.devolverCompra(i).obtenerProducto().getPrecio();
            }
        }
        return suma;
    }
}
