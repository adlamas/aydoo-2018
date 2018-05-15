
Este es el informe del fibo3 recibido

a) ¿Cumple con la consigna fibo3?
No, no las cumple. Al escribir java -jar fibo.jar -o=vd -f=salida.txt 5 en la consola (O en cualquier archivo), en el mensaje de salida, repite la extensión del archivo.

b) ¿Tiene suficientes tests?
No, le faltan bastantes test. Faltan los test de la impresion de la suma o lista, las direcciones y el orden al imprimir en un archivo.

c) ¿Respeta las convenciones Java?
En casi todos los puntos respeta las convenciones java para métodos, clases, variables, paquetes.
Sólo en algunos métodos como sumatoriaDeLaSerieDeFibonacci no están escritos exactamente como un verbo al principio.

d) ¿Respeta los principio SOLID? En caso que no los respete indique que principio viola y porque.

S: La clase ImpresionPantalla podría separarse en dos, una que imprima los numeros y otra que determine el modo de funcionamiento para no archivos. La clase principal Program, hace demasiadas cosas y podría separarse en más clases como por ejemplo una clase Parametros que tome los parametros introducidos y los guarde. El SRP no se cumple.

O: No cumple este principio. Se puede ver claramente que para agregar una opción más de salida se necesita cambiar la clase Program.

L: Todos los métodos del programa sólo reciben objetos primitivos.

I: 
