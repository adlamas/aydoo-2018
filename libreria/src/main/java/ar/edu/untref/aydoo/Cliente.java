package ar.edu.untref.aydoo;

public class Cliente {

    private CuentaCorriente cuentaCorriente = new CuentaCorriente();

    public void setCuentaCorriente(CuentaCorriente cuenta){
        this.cuentaCorriente = cuenta;

    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }
}
