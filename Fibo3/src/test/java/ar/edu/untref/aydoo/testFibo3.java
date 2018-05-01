package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class testFibo3 {

    @Test
    public void imprimirAlgoEnArchivoVD(){

        String[] args = {"-o=vd","-f=salida.txt","-m=l", "8"};
        fibo.main(args);
    }

    @Test
    public void guardarEnArray(){

        arregloDeNumeros claseArreglo = new arregloDeNumeros();
        int[] arreglo = claseArreglo.obtenerArregloDeNumerosDeFibonacci(8);
        int[] arregloEsperado = {0,1,1,2,3,5,8,13};
        System.out.println(Arrays.toString(arreglo));
        System.out.println(Arrays.toString(arregloEsperado));

        Assert.assertTrue(Arrays.equals(arregloEsperado,arreglo));

    }

    @Test
    public void testFuncionSumarNumeros(){

        int[] arregloEsperado = {0,1,1,2,3,5,8,13};
        opcionM M = new opcionM();
        int suma = M.sumarNumeros(arregloEsperado);

        Assert.assertEquals(33, suma);

    }


}
