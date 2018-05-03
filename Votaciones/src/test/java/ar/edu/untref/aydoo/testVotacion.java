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
    public void votarAUnCandidatoDeUnaProvinciaEnVotaciones(){

        Partido FPV = new Partido("Frente para la victoria");
        Candidato LuisDlia = new Candidato("Luis",  FPV);
        Votacion votacionesBuenosAires = new Votacion();
        Provincia BuenosAires = new Provincia("Bs As");
        Voto votoLuis = new Voto(LuisDlia, BuenosAires);
        votacionesBuenosAires.agregarVoto(votoLuis);

        Assert.assertEquals(votoLuis, votacionesBuenosAires.obtenerVoto(0));
    }

    @Test
    public void votarDosCandidatosDeUnaProvinciaEnVotaciones(){
        Partido FPV = new Partido("Frente para la victoria");
        Candidato LuisDlia = new Candidato("Luis Dlia",  FPV);
        Candidato NestorKirchner = new Candidato("Nestor Kirchner",  FPV);
        Votacion votacionesBuenosAires = new Votacion();
        Provincia BuenosAires = new Provincia("Bs As");
        Voto votoLuis = new Voto(LuisDlia, BuenosAires);
        Voto votoNestor = new Voto(NestorKirchner, BuenosAires);
        votacionesBuenosAires.agregarVoto(votoLuis);
        votacionesBuenosAires.agregarVoto(votoNestor);

        Assert.assertEquals(votoLuis, votacionesBuenosAires.obtenerVoto(0));
        Assert.assertEquals(votoNestor, votacionesBuenosAires.obtenerVoto(1));
    }

    @Test
    public void contarCuantosVotosPorCandidato(){
        Partido FPV = new Partido("Frente para la victoria");
        Partido PRO = new Partido("Pro");
        Candidato NestorKirchner = new Candidato("Nestor Kirchner",  FPV);
        Candidato MauricioMacri = new Candidato("MauricioMacri", PRO  );
        Votacion votacionesBsAs = new Votacion();
        Provincia BuenosAires = new Provincia("Bs As");
        Voto votoNestor = new Voto(NestorKirchner, BuenosAires);
        Voto votoMauri = new Voto(MauricioMacri, BuenosAires);
        Voto votoMauri2 = new Voto(MauricioMacri, BuenosAires);
        Voto votoMauri3 = new Voto(MauricioMacri, BuenosAires);
        votacionesBsAs.agregarVoto(votoMauri2);
        votacionesBsAs.agregarVoto(votoNestor);
        votacionesBsAs.agregarVoto(votoMauri);
        votacionesBsAs.agregarVoto(votoMauri3);

        Assert.assertEquals(3, votacionesBsAs
                .obtenerCantidadDeVotosDeCandidatoPorProvincia(BuenosAires, MauricioMacri));
    }
}
