package ar.edu.untref.aydoo;

public class Registro {

    private boolean registrado = false;

    public void registrarse(){
        this.registrado = true;
    }

    public boolean estaRegistrado(){
        return registrado;
    }
}
