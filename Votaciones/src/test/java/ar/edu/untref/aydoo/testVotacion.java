package ar.edu.untref.aydoo;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;


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
        Partido partido1 = new Partido("Partido Random 1");
        Partido partido2 = new Partido("Partido random 2");
        Provincia LaRioja = new Provincia("LaRioja");

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
        Provincia BsAs = new Provincia("Bs As");
        Provincia Mendoza = new Provincia("Mendoza");
        Provincia LaRioja = new Provincia("LaRioja");
        Provincia Corrientes = new Provincia("Corrientes");

        Partido partido1 = new Partido("Partido Random 1");
        Partido partido2 = new Partido("Partido random 2");
        Partido partido3 = new Partido("Partido random 3");
        Partido partido4 = new Partido("Partido random 4");


        Candidato candidato1 = new Candidato("candidato1", partido1, BsAs);
        Candidato candidato2 = new Candidato("candidato2", partido1, BsAs);
        Candidato candidato4 = new Candidato("candidato4", partido1, Mendoza);
        Candidato candidato5 = new Candidato("candidato5", partido1, Mendoza);
        Candidato candidato9 = new Candidato("candidato9", partido1, LaRioja);
        Candidato candidato10 = new Candidato("candidato10", partido1, LaRioja);

        Candidato candidato3 = new Candidato("candidato3", partido2, BsAs);
        Candidato candidato6 = new Candidato("candidato6", partido2, Mendoza);
        Candidato candidato7 = new Candidato("candidato7", partido2, Mendoza);
        Candidato candidato8 = new Candidato("candidato8", partido2, LaRioja);

        Candidato candidato11 = new Candidato("candidato11", partido3, LaRioja);
        Candidato candidato12 = new Candidato("candidato12", partido3, LaRioja);
        Candidato candidato13 = new Candidato("candidato13", partido3, LaRioja);

        Candidato candidato14 = new Candidato("candidato14", partido4, Corrientes);
        Candidato candidato15 = new Candidato("candidato15", partido4, Corrientes);
        Candidato candidato16 = new Candidato("candidato16", partido4, Corrientes);

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
        votaciones.agregarCandidato(candidato11);
        votaciones.agregarCandidato(candidato12);
        votaciones.agregarCandidato(candidato13);
        votaciones.agregarCandidato(candidato14);
        votaciones.agregarCandidato(candidato15);
        votaciones.agregarCandidato(candidato16);

        votaciones.votar(candidato1);
        votaciones.votar(candidato1);
        votaciones.votar(candidato1);
        votaciones.votar(candidato2);
        votaciones.votar(candidato4);


        votaciones.votar(candidato6);
        votaciones.votar(candidato6);
        votaciones.votar(candidato8);
        votaciones.votar(candidato8);
        votaciones.votar(candidato8);
        votaciones.votar(candidato8);
        votaciones.votar(candidato8);
        votaciones.votar(candidato8);
        votaciones.votar(candidato8);

        votaciones.votar(candidato11);
        votaciones.votar(candidato11);
        votaciones.votar(candidato11);
        votaciones.votar(candidato12);
        votaciones.votar(candidato12);
        votaciones.votar(candidato12);
        votaciones.votar(candidato13);
        votaciones.votar(candidato13);

        Partido partidoGanador = votaciones.obtenerPartidoConMasVotos();


        Assert.assertEquals(partido2, partidoGanador);


    }


}
