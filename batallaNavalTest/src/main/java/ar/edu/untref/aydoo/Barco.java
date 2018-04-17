package ar.edu.untref.aydoo;

public class Barco {

    int longitud;
    ParteDeBarco partesDelBarco[];

    public Barco(int longitud) {
        this.longitud = longitud;
        partesDelBarco = new ParteDeBarco[longitud];

        for(int i = 0; i < longitud; i++){
            partesDelBarco[i] = new ParteDeBarco();
        }
    }

    public int getLongitud(){
        return longitud;
    }

    public ParteDeBarco getParteDelBarco(int indice) {
        return partesDelBarco[indice];
    }

    public EstadoBarco responderSiSeHaRecibidoUnDisparo(Posicion posicion)
    {
        System.out.println(this.partesDelBarco[0]);
        EstadoBarco estado = null;
        for(int i = 0; i < partesDelBarco.length ; i++){
            if(posicion.obtenerContenido().equals(this.partesDelBarco[i])){
                estado = EstadoBarco.TOCADO;
            }
        }
        return estado;
    }
}
