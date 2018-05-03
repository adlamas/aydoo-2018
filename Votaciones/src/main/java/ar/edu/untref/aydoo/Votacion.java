package ar.edu.untref.aydoo;

import java.util.LinkedList;

public class Votacion {

    private LinkedList<Voto> votos = new LinkedList<Voto>();

    public void agregarVoto(Voto voto){
        this.votos.add(voto);
    }

    public int cantidadDeVotos(){
        return this.votos.size();
    }


    public Voto obtenerVoto(int i) {
        return this.votos.get(i);
    }

    public int obtenerCantidadDeVotosDeCandidatoPorProvincia(Provincia provincia, Candidato candidato) {
        int cantidadDeCandidatosPorProvincia = 0;
        for(int i = 0; i < votos.size(); i++){
            if(votos.get(i).getCandidato() == candidato && votos.get(i).getProvincia() == provincia){
                cantidadDeCandidatosPorProvincia++;
            }
        }

        return  cantidadDeCandidatosPorProvincia;
    }
}
