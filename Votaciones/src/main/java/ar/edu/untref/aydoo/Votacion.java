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

    public int obtenerCantidadDeVotosParaUnPartido(Partido partido) {
        int sumaDeVotos = 0;
        for (int i = 0; i < candidatos.size(); i++){
            if(candidatos.get(i).getPartido() == partido){
                sumaDeVotos = sumaDeVotos + candidatos.get(i).obtenerCantidadDeVotos();
            }
        }
        return sumaDeVotos;
    }

    public Partido obtenerPartidoConMasVotos() {

        class parPartidoVoto{

            Partido partido;
            int votos = 0;

            public parPartidoVoto(Partido partido){
                this.partido = partido;
            }

            public Partido getPartido() {
                return partido;
            }

            public int getVotos() {
                return votos;
            }

            public void sumarVotos(int votosASumar){
                votos = votos + votosASumar;
            }
        }
        //Si la lista de partidos no lo contiene, sumar a la lista
        //Si la lista de partidos lo contiene, sumar los votos del candidato

        LinkedList<Partido> partidosParticipantes = new LinkedList<Partido>();
        LinkedList<parPartidoVoto> parPartidosVotos = new LinkedList<parPartidoVoto>();


        for (int i = 0; i < candidatos.size(); i++) {
            Partido partidoDeCandidato = candidatos.get(i).getPartido();

            if (!partidosParticipantes.contains(partidoDeCandidato)) {
                partidosParticipantes.add(partidoDeCandidato);
            }
            //Pongo todos los partidos existentes
            //Seteo en los pares, los partidos Existentes con votos en 0
            //Por cada candidato, si su partido coincide con el atributo partido del par, sumo sus votos al
            //atributo votos del mismo objeto par
        }

        for(int i = 0; i < partidosParticipantes.size(); i++){
            parPartidoVoto parPV = new parPartidoVoto(partidosParticipantes.get(i));
            parPartidosVotos.add(parPV);
        }


        for (int i = 0; i < candidatos.size(); i++) {
            Partido partidoCandidatoActual = candidatos.get(i).getPartido();
            for(int j = 0; j < parPartidosVotos.size(); j++){
                if(parPartidosVotos.get(j).getPartido() == partidoCandidatoActual){
                    parPartidosVotos.get(j).sumarVotos(candidatos.get(i).obtenerCantidadDeVotos());
                }
            }
        }

        int indice = 0;
        int votosDePartidoConMasVotos = 0;

        for(int i = 0; i < parPartidosVotos.size(); i++){
            if(parPartidosVotos.get(i).getVotos() > votosDePartidoConMasVotos){
                votosDePartidoConMasVotos = parPartidosVotos.get(i).getVotos();
                indice = i;
            }
        }

        return parPartidosVotos.get(indice).getPartido();
    }
}
