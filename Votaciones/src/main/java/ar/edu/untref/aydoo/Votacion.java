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

    public int obtenerCantidadDeCandidatosParaUnaProvincia(Provincia provincia) {
        int sumaDeCandidatos = 0;
        for (int i = 0; i < candidatos.size(); i++){
            if(candidatos.get(i).getProvinciaARepresentar() == provincia){
                sumaDeCandidatos++;
            }
        }
        return sumaDeCandidatos;

    }

    public Candidato obtenerCandidatoConMasVotosDeUnaProvincia(Provincia provincia){
        LinkedList<Candidato> candidatosDeProvincia = new LinkedList<Candidato>();
        for(int i = 0; i < candidatos.size(); i++){
            if(candidatos.get(i).getProvinciaARepresentar() == provincia){
                candidatosDeProvincia.add(candidatos.get(i));
            }
        }

        Candidato candidatoConMasVotos = candidatosDeProvincia.get(0);
        for (int i = 1; i < candidatosDeProvincia.size(); i++){
            if(candidatosDeProvincia.get(i).obtenerCantidadDeVotos()
                    > candidatoConMasVotos.obtenerCantidadDeVotos()){
                candidatoConMasVotos = candidatosDeProvincia.get(i);
            }
        }

        return candidatoConMasVotos;

    }

    public LinkedList<Candidato> obtenerCandidatoConMasVotosDeTodasLasProvincias(){
        LinkedList<Candidato> candidatosConMasVotosPorProvincia = new LinkedList<Candidato>();
        LinkedList<Provincia> provinciasParticipantes = new LinkedList<Provincia>();
        for(int i = 0; i < this.candidatos.size(); i++){
            if(!provinciasParticipantes.contains(candidatos.get(i).getProvinciaARepresentar())){
                provinciasParticipantes.add(candidatos.get(i).getProvinciaARepresentar());
            }
        }

        for (int i = 0; i < provinciasParticipantes.size(); i++){
            candidatosConMasVotosPorProvincia.
                    add(obtenerCandidatoConMasVotosDeUnaProvincia(provinciasParticipantes.get(i)));
        }

        return candidatosConMasVotosPorProvincia;
    }

    public int obtenerCantidadDeCandidatosParaUnPartido(Partido partido) {
        int sumaDeCandidatos = 0;
        for (int i = 0; i < candidatos.size(); i++){
            if(candidatos.get(i).getPartido() == partido){
                sumaDeCandidatos++;
            }
        }
        return sumaDeCandidatos;
    }
}
