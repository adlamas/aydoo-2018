package ar.edu.untref.aydoo;

public class Candidato {

    private String nombreCompleto;
    private Partido partido;
    private Provincia provinciaARepresentar;
    private int votos = 0;

    public Candidato(String nombreCompleto, Partido partido, Provincia provinciaARepresentar){
        this.nombreCompleto = nombreCompleto;
        this.partido = partido;
        this.provinciaARepresentar = provinciaARepresentar;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public Partido getPartido() {
        return partido;
    }

    public Provincia getProvinciaARepresentar() {
        return provinciaARepresentar;
    }

    public int obtenerCantidadDeVotos(){
        return votos;
    }

    public void sumarVoto(){
        votos = votos + 1;
    }
}
