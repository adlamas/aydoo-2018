package ar.edu.untref.aydoo;

public class Candidato {

    private String nombreCompleto;
    private Partido partido;

    public Candidato(String nombreCompleto, Partido partido){
        this.nombreCompleto = nombreCompleto;
        this.partido = partido;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public Partido getPartido() {
        return partido;
    }
}
