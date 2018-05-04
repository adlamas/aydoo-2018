package ar.edu.untref.aydoo;
import gherkin.lexer.Lu;
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
    public void votar3VecesAUnCandidatoEnVotacionesYObtenerTalNumero(){

        Provincia BuenosAires = new Provincia("Bs As");
        Partido FPV = new Partido("Frente para la victoria");
        Candidato LuisDlia = new Candidato("Luis",  FPV, BuenosAires);
        Votacion votacionesBuenosAires = new Votacion();

        votacionesBuenosAires.agregarCandidato(LuisDlia);
        votacionesBuenosAires.votar(LuisDlia);
        votacionesBuenosAires.votar(LuisDlia);
        votacionesBuenosAires.votar(LuisDlia);

        Assert.assertEquals(3, LuisDlia.obtenerCantidadDeVotos());
    }

    @Test
    public void calcularCantidadDeCandidatosParaUnaProvincia(){
        Provincia BsAs = new Provincia("Bs As");
        Partido FPV = new Partido("Frente para la victoria");
        Candidato LuisDlia = new Candidato("Luis",  FPV, BsAs);
        Candidato Nestor = new Candidato("Nestor",  FPV, BsAs);
        Candidato Kicillof = new Candidato("Axel",  FPV, BsAs);
        Votacion votacionesBsAs = new Votacion();
        votacionesBsAs.agregarCandidato(LuisDlia);
        votacionesBsAs.agregarCandidato(Nestor);
        votacionesBsAs.agregarCandidato(Kicillof);

        Assert.assertEquals(3, votacionesBsAs.obtenerCantidadDeCandidatosParaUnaProvincia(BsAs));
    }

}
