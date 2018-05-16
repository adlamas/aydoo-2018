package ar.edu.untref.aydoo;

public class ImpresionPantalla {

	public static void mostrarNumerosSegunOrientacion(final char orientacion, final int numero,
													  final int[] resultado) {

    	System.out.printf("fibo<%d>: ", numero);
	    if (orientacion == 'v') {
	    	System.out.printf("\r\n");
	    	for (int i = 0; i < resultado.length; i++) {
		    	System.out.printf("%d \r\n", resultado[i]);
		    }
	    
	    } else if(orientacion == 'h' || orientacion == 0) {
	    	for (int i = 0; i < resultado.length; i++) {
		    	System.out.printf("%d ", resultado[i]);
		    }
	    }

	    else if (orientacion == 'p'){
	    	System.out.println();
	    	for (int i = 1; i <= resultado.length; i++){
				for (int j = 0; j < resultado.length - (resultado.length - i); j++ ){
					System.out.printf("%d ", resultado[j]);
				}
				System.out.println();
			}
		}
    }
	
	public static void mostrarNumerosSegunModoDeFuncionamiento(final char funcionamiento,
						final char orientacion, final int numero, final int[] resultado) {

    	if (funcionamiento == 'l') {
    		ImpresionPantalla.mostrarNumerosSegunOrientacion(orientacion, numero, resultado);
			
		} else {
			if (orientacion == 'h' || orientacion == 0) {
				System.out.printf("fibo<%d>s: %d", numero, SerieFibonacci.
						sumatoriaDeLaSerieDeFibonacci(resultado));

			} else {
				System.out.printf("fibo<%d>s: ", numero);
				System.out.printf("\r\n");
				System.out.printf("%d ", SerieFibonacci.sumatoriaDeLaSerieDeFibonacci(resultado));
			}
		}
    }
}
