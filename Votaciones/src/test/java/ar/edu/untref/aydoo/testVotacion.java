package ar.edu.untref.aydoo;
import gherkin.lexer.Ca;
import gherkin.lexer.Lu;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

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

    @Test
    public void calcularCandidatoConMasVotosEnUnaProvincia(){
        Provincia BsAs = new Provincia("Bs As");
        Partido FPV = new Partido("Frente para la victoria");
        Candidato LuisDlia = new Candidato("Luis",  FPV, BsAs);
        Candidato Nestor = new Candidato("Nestor",  FPV, BsAs);
        Candidato Kicillof = new Candidato("Axel",  FPV, BsAs);
        Votacion votacionesBsAs = new Votacion();
        votacionesBsAs.agregarCandidato(LuisDlia);
        votacionesBsAs.agregarCandidato(Nestor);
        votacionesBsAs.agregarCandidato(Kicillof);

        votacionesBsAs.votar(LuisDlia);
        votacionesBsAs.votar(LuisDlia);
        votacionesBsAs.votar(Nestor);
        votacionesBsAs.votar(Nestor);
        votacionesBsAs.votar(Nestor);
        votacionesBsAs.votar(Nestor);
        votacionesBsAs.votar(Kicillof);
        votacionesBsAs.votar(Kicillof);
        votacionesBsAs.votar(Kicillof);

        Candidato candidatoConMasVotos = votacionesBsAs.obtenerCandidatoConMasVotosDeUnaProvincia(BsAs);

        Assert.assertEquals(Nestor, candidatoConMasVotos);
        Assert.assertEquals("Nestor", candidatoConMasVotos.getNombreCompleto());
        Assert.assertEquals(4, candidatoConMasVotos.obtenerCantidadDeVotos());

    }

    @Test
    public void calcularCandidatoConMasVotosEnCadaProvincia(){
        Provincia BsAs = new Provincia("Bs As");
        Provincia Mendoza = new Provincia("Mendoza");
        Provincia LaRioja = new Provincia("LaRioja");

        Partido partido1 = new Partido("Partido Random 1");
        Candidato candidato1 = new Candidato("candidato1", partido1, BsAs);
        Candidato candidato2 = new Candidato("candidato2", partido1, BsAs);
        Candidato candidato3 = new Candidato("candidato3", partido1, BsAs);
        Candidato candidato4 = new Candidato("candidato4", partido1, Mendoza);
        Candidato candidato5 = new Candidato("candidato5", partido1, Mendoza);
        Candidato candidato6 = new Candidato("candidato6", partido1, Mendoza);
        Candidato candidato7 = new Candidato("candidato7", partido1, Mendoza);
        Candidato candidato8 = new Candidato("candidato8", partido1, LaRioja);
        Candidato candidato9 = new Candidato("candidato9", partido1, LaRioja);
        Candidato candidato10 = new Candidato("candidato10", partido1, LaRioja);

        Votacion votaciones = new Votacion();
        votaciones.agregarCandidato(candidato1);
        votaciones.agregarCandidato(candidato2);
        votaciones.agregarCandidato(candidato3);
        votaciones.agregarCandidato(candidato4);
        votaciones.agregarCandidato(candidato5);
        votaciones.agregarCandidato(candidato6);
        votaciones.agregarCandidato(candidato7);
        votaciones.agregarCandidato(candidato8);
        votaciones.agregarCandidato(candidato9);
        votaciones.agregarCandidato(candidato10);

        votaciones.votar(candidato1);
        votaciones.votar(candidato1);
        votaciones.votar(candidato1);
        votaciones.votar(candidato2);
        votaciones.votar(candidato4);
        votaciones.votar(candidato4);
        votaciones.votar(candidato4);
        votaciones.votar(candidato5);
        votaciones.votar(candidato6);
        votaciones.votar(candidato6);
        votaciones.votar(candidato8);
        votaciones.votar(candidato8);
        votaciones.votar(candidato8);
        votaciones.votar(candidato9);
        votaciones.votar(candidato9);
        votaciones.votar(candidato10);
        votaciones.votar(candidato10);

        LinkedList<Candidato> candidatosConMasVotosDeCadaProvincia = votaciones
                .obtenerCandidatoConMasVotosDeTodasLasProvincias();

        Assert.assertEquals(candidato1, candidatosConMasVotosDeCadaProvincia.get(0));
        Assert.assertEquals(candidato4, candidatosConMasVotosDeCadaProvincia.get(1));
        Assert.assertEquals(candidato8, candidatosConMasVotosDeCadaProvincia.get(2));

    }

    @Test
    public void calcularCandidatosDeUnPartido(){
        Provincia BsAs = new Provincia("Bs As");
        Provincia Mendoza = new Provincia("Mendoza");
        Provincia LaRioja = new Provincia("LaRioja");

        Partido partido1 = new Partido("Partido Random 1");
        Partido partido2 = new Partido("Partido random 2");
        Candidato candidato1 = new Candidato("candidato1", partido1, BsAs);
        Candidato candidato2 = new Candidato("candidato2", partido1, BsAs);
        Candidato candidato3 = new Candidato("candidato3", partido2, BsAs);
        Candidato candidato4 = new Candidato("candidato4", partido1, Mendoza);
        Candidato candidato5 = new Candidato("candidato5", partido1, Mendoza);
        Candidato candidato6 = new Candidato("candidato6", partido2, Mendoza);
        Candidato candidato7 = new Candidato("candidato7", partido2, Mendoza);
        Candidato candidato8 = new Candidato("candidato8", partido2, LaRioja);
        Candidato candidato9 = new Candidato("candidato9", partido1, LaRioja);
        Candidato candidato10 = new Candidato("candidato10", partido1, LaRioja);

        Votacion votaciones = new Votacion();
        votaciones.agregarCandidato(candidato1);
        votaciones.agregarCandidato(candidato2);
        votaciones.agregarCandidato(candidato3);
        votaciones.agregarCandidato(candidato4);
        votaciones.agregarCandidato(candidato5);
        votaciones.agregarCandidato(candidato6);
        votaciones.agregarCandidato(candidato7);
        votaciones.agregarCandidato(candidato8);
        votaciones.agregarCandidato(candidato9);
        votaciones.agregarCandidato(candidato10);

        Assert.assertEquals(6, votaciones.obtenerCantidadDeCandidatosParaUnPartido(partido1));
    }

    @Test
    public void calcularVotosDeUnPartido(){
        Provincia BsAs = new Provincia("Bs As");
        Provincia Mendoza = new Provincia("Mendoza");
        Provincia LaRioja = new Provincia("LaRioja");

        Partido partido1 = new Partido("Partido Random 1");
        Partido partido2 = new Partido("Partido random 2");
        Candidato candidato1 = new Candidato("candidato1", partido1, BsAs);
        Candidato candidato2 = new Candidato("candidato2", partido1, BsAs);
        Candidato candidato3 = new Candidato("candidato3", partido2, BsAs);
        Candidato candidato4 = new Candidato("candidato4", partido1, Mendoza);
        Candidato candidato5 = new Candidato("candidato5", partido1, Mendoza);
        Candidato candidato6 = new Candidato("candidato6", partido2, Mendoza);
        Candidato candidato7 = new Candidato("candidato7", partido2, Mendoza);
        Candidato candidato8 = new Candidato("candidato8", partido2, LaRioja);
        Candidato candidato9 = new Candidato("candidato9", partido1, LaRioja);
        Candidato candidato10 = new Candidato("candidato10", partido1, LaRioja);

        Votacion votaciones = new Votacion();
        votaciones.agregarCandidato(candidato1);
        votaciones.agregarCandidato(candidato2);
        votaciones.agregarCandidato(candidato3);
        votaciones.agregarCandidato(candidato4);
        votaciones.agregarCandidato(candidato5);
        votaciones.agregarCandidato(candidato6);
        votaciones.agregarCandidato(candidato7);
        votaciones.agregarCandidato(candidato8);
        votaciones.agregarCandidato(candidato9);
        votaciones.agregarCandidato(candidato10);

        votaciones.votar(candidato1);
        votaciones.votar(candidato1);
        votaciones.votar(candidato1);
        votaciones.votar(candidato2);
        votaciones.votar(candidato4);
        votaciones.votar(candidato4);
        votaciones.votar(candidato4);
        votaciones.votar(candidato5);
        votaciones.votar(candidato6);
        votaciones.votar(candidato6);
        votaciones.votar(candidato8);
        votaciones.votar(candidato8);
        votaciones.votar(candidato8);
        votaciones.votar(candidato9);
        votaciones.votar(candidato9);
        votaciones.votar(candidato10);
        votaciones.votar(candidato10);

        Assert.assertEquals(12, votaciones.obtenerCantidadDeVotosParaUnPartido(partido1));

    }

    @Test
    public void calcularPartidoConMasVotos(){

    }


}
