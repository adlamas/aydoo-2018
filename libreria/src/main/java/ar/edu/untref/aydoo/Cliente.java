package ar.edu.untref.aydoo;

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
}
