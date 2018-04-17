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
}
