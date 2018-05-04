package ar.edu.untref.aydoo;

import java.util.LinkedList;

public class Votacion {

    private LinkedList<Candidato> candidatos = new LinkedList<Candidato>();

    public void agregarCandidato(Candidato candidato){
        candidatos.add(candidato);
    }

    public Candidato obtenerCandidato(int index){
        return candidatos.get(index);
    }

    public void votar(Candidato candidato){
        for(int i = 0; i < candidatos.size(); i++){
            if(candidatos.get(i) == candidato){
                candidatos.get(i).sumarVoto();
            }
        }
    }

}
