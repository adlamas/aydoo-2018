package ar.edu.untref.aydoo;
import java.io.*;

public class fibo {
    public static void main(String[] args) {

        int limite = Integer.parseInt(args[args.length -1]);
        arregloDeNumeros claseArreglo = new arregloDeNumeros();
        int[] arreglo = claseArreglo.obtenerArregloDeNumerosDeFibonacci(limite);

        String opcionO;
        String opcionF;
        String opcionM;


        for(int i = 0; i < args.length -1; i++){
            String subString = args[i].substring(0,2);

            if(subString.equals("-m")){
                opcionM = args[i].toString();
                System.out.println(opcionM);
            }
            if(subString.equals("-f")){
                opcionF = args[i].toString();
                System.out.println(opcionF);
            }
            if(subString.equals("-o")){
                opcionO = args[i].toString();
                System.out.println(opcionO);

            }
        }



    }

}
