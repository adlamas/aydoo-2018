package ar.edu.untref.aydoo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class opcionO {

    public void imprimirEnArchivo(String args[]){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {

            String nombreFichero = args[1].substring(3);
            //System.out.println(nombreFichero);
            fichero = new FileWriter(nombreFichero);
            pw = new PrintWriter(fichero);

            int numero1 = 0;
            int numero2 = 1;
            int temporal;
            int limite = Integer.parseInt(args[args.length - 1]);

            //System.out.print("fibo<" + args[0] + ">: " + numero1 + " ");
            System.out.print(numero2 + " ");


            for (int i = 1; i <= limite - 2; i++) {
                temporal = numero1;
                numero1 = numero2;
                numero2 = temporal + numero1;
                System.out.println(numero2);
                pw.print(numero2 + " ");
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fichero.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
