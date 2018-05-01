package ar.edu.untref.aydoo;

public class opcionM {
    public static int sumarNumeros(int[] arregloEsperado) {

        int suma = 0;
        for(int i = 0; i < arregloEsperado.length; i++){
            suma += arregloEsperado[i];
        }

        return suma;
    }
}
