package ar.edu.untref.aydoo;

public class Partido {

    private String nombrePartido;

    public Partido(String nombrePartido){
        this.nombrePartido = nombrePartido;
    }

    public void setNombrePartido(String nombrePartido){
        this.nombrePartido = nombrePartido;
    }

    public String getNombrePartido() {
        return nombrePartido;
    }
}
