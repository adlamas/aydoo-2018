package ar.edu.untref.aydoo;
import org.junit.Assert;
import org.junit.Test;

/*
En las votaciones Primaria Abiertas Simultáneas Obligatorias (PASO) compiten candidatos de varios partidos.
Cada candidato representa a un único partido pero cada partido puede tener varios candidatos.

Considerando el escenario de una votación nacional se pide:
* Calcular el candidato que más votos logró en cada provincia
* Calcular el partido que más votos logró a nivel nacional (sumatoria de provincias de los votos del partido)
*/

public class testVotacion {

    @Test
    public void votarAUnCandidato(){

        Partido FPV = new Partido("Frente para la victoria");
        Candidato LuisDlia = new Candidato("Luis",  FPV);
        Votacion votacionesBuenosAires = new Votacion();
        Provincia BuenosAires = new Provincia("Bs As");
        Voto votoLuis = new Voto(LuisDlia, BuenosAires);
        votacionesBuenosAires.agregarVoto(votoLuis);

        Assert.assertEquals(votoLuis, votacionesBuenosAires.obtenerVoto(0));

    }
}
