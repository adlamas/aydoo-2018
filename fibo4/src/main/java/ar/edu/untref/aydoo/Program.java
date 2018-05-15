package ar.edu.untref.aydoo;

import java.util.LinkedList;

public class Program {

	private static int numero;
	private static int[] resultado;
	private static String formato;
	private static char orientacion;
	private static char direccion;
	private static boolean pares = false;
	
    public static final void main(final String[] args) {
	    numero = Integer.parseInt(args[args.length - 1]);
	    resultado = new int[numero];
	    SerieFibonacci.calcularSerie(numero, resultado);
	    
	    if (args.length == 1) {
	    	ImpresionPantalla.mostrarNumerosSegunOrientacion('h', numero, resultado);
	    	
	    }
	    else
	    {
	    	String modoFuncionamiento = null;
	    	char funcionamiento = ' ';
	    	String salida = null;
	    	String[] salidaPartes = null;
	    	String nombreDelArchivo = null;

	    	for (int i = 0; i < args.length - 1; i++) {
	    		if (args[i].startsWith("-o")) {
	    			formato = String.valueOf(args[i]);
	    			orientacion = formato.charAt(3);
				    direccion = formato.charAt(4);
				    if (direccion == 'i') {
				    	resultado = ordenarEnFormaDescendente(resultado);
				    }

	    		}
	    		else if (args[i].startsWith("-m")) {
	    			modoFuncionamiento = String.valueOf(args[i]);
	    			funcionamiento = modoFuncionamiento.charAt(3);

	    		}
	    		else if (args[i].startsWith("-f")) {
	    			salida = String.valueOf(args[i]);
	    			salidaPartes = salida.split("=");
	    			nombreDelArchivo = salidaPartes[1];
	    		}
	    		else if(args[i].startsWith("-n")){
					LinkedList<Integer> lista = new LinkedList<Integer>();
					for(int j = 0; j < resultado.length; j++){

						if(resultado[j] % 2 == 0 && resultado[j] != 0){
							lista.add(resultado[j]);
						}
					}

					int tamanioDeResultadoNuevo = lista.size();
					int[] arregloSoloDePares = new int[tamanioDeResultadoNuevo];
					for(int j = 0; j < tamanioDeResultadoNuevo; j++ ){
						arregloSoloDePares[j] = lista.get(j);
					}
					pares = true;
					resultado = arregloSoloDePares;
				}

	    	}



	    	if (( (orientacion != 0 && (orientacion != 'h' && orientacion != 'v' && orientacion != 'p')))
					|| ( direccion != 0 && (direccion != 'd' && direccion != 'i')) ){
		    	System.out.printf("Opciones no validas.");
		    	
		    }
		    else {
		    	if (formato != null && modoFuncionamiento == null && salida == null || args.length == 2 ) {
		    		if (direccion == 'i') {
				    	resultado = ordenarEnFormaDescendente(resultado);
				    }
		    		ImpresionPantalla.mostrarNumerosSegunOrientacion(orientacion, numero, resultado);
				    
		    	} else if (modoFuncionamiento != null && salida == null ) {
		    		ImpresionPantalla.mostrarNumerosSegunModoDeFuncionamiento(funcionamiento, orientacion, numero, resultado);
		    		
		    	} else if (nombreDelArchivo != null ) {
		    		Archivo.escribirSobreArchivo(nombreDelArchivo, funcionamiento, orientacion, numero, resultado);
		    	}
		    }
	    }
    }
    
    private static int[] ordenarEnFormaDescendente(final int[] numeros) {
		int[] numerosDescendentes = numeros;
		for (int i = 0; i < numerosDescendentes.length - 1; i++) {
			for (int j = i + 1; j < numerosDescendentes.length; j++) {
				if (numerosDescendentes[i] < numerosDescendentes[j]) {
					int auxiliar = numerosDescendentes[i];
					numerosDescendentes[i] = numerosDescendentes[j];
					numerosDescendentes[j] = auxiliar;
				}
			}
		}
		return numerosDescendentes;
	} 
}
