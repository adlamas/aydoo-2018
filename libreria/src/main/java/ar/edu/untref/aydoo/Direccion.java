package ar.edu.untref.aydoo;

public class Direccion {

    String calle;
    int numero;

    public Direccion(String calle, int numero){
        this.calle = calle;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public String getCalle() {
        return calle;
    }

    public void setDireccion(String calle, int numero){
        this.calle = calle;
        this.numero = numero;
    }
}
