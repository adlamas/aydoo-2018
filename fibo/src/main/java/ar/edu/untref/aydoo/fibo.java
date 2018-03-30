package ar.edu.untref.aydoo;

public class fibo {
    public static void main(String[] args){
        int numero1 = 0;
        int numero2 = 1;
        int temporal;
        int limite = Integer.parseInt(args[0]);
        System.out.print("fibo<"+ args[0] + ">: " + numero1 + " ");
        System.out.print(numero2 + " ");
        for(int i = 1; i <= limite-2; i++){
            temporal = numero1;
            numero1 = numero2;
            numero2 = temporal + numero1;
            System.out.print(numero2 + " ");
        }
    }
}

//Lo hice así por que, supuestamente, la sucesión empieza con 0 y 1.