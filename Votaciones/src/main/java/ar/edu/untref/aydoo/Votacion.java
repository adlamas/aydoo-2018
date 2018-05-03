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
}
