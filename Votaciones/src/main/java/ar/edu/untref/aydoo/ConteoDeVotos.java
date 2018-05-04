package ar.edu.untref.aydoo;

public class ConteoDeVotos {

    private Candidato candidato;
    private int totalDeVotos;

    public ConteoDeVotos(Candidato candidato, int totalDeVotos){
        this.candidato = candidato;
        this.totalDeVotos = totalDeVotos;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public void setTotalDeVotos(int totalDeVotos) {
        this.totalDeVotos = totalDeVotos;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public int getTotalDeVotos() {
        return totalDeVotos;
    }
}
