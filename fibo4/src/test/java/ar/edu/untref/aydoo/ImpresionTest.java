package ar.edu.untref.aydoo;
import org.junit.Test;
import org.junit.Assert;


public class ImpresionTest {

    @Test
    public void testImprimirArreglo(){

        String argumentos[] = {"-o=vd", "8"};
        Program.main(argumentos);
    }

    @Test
    public void testImprimirEnArchivo(){

        String argumentos[] = {"-o=vd","-f=archivodesalida.txt", "8"};
        Program.main(argumentos);
    }

    @Test
    public void testImprimirProgresivamente(){
        String argumentos[] = {"-o=pd", "8"};
        Program.main(argumentos);
    }

    @Test
    public void testImprimirProgresivamenteInverso(){
        String argumentos[] = {"-o=pi", "8"};
        Program.main(argumentos);
    }

    @Test
    public void opcionesNoValidas1(){
        String argumentos[] = {"-o=ph", "8"};
        Program.main(argumentos);
        System.out.println();

    }

    @Test
    public void opcionesNoValidas2(){

        String argumentos2[] = {"-o=pv", "8"};
        Program.main(argumentos2);
        System.out.println();

    }

    @Test
    public void impresionPares8(){
        String argumentos[] = {"-o=vi", "-n=p", "8"};
        Program.main(argumentos);

    }

    @Test
    public void impresionParesSinV(){
        String argumentos[] = {"-n=p", "8"};
        Program.main(argumentos);

    }

    @Test
    public void impresionConPares16(){
        String argumentos[] = {"-n=p", "16"};
        Program.main(argumentos);

    }

    @Test
    public void impresionSumaConPares(){
        String argumentos[] = {"-n=p","-m=s", "16"};
        Program.main(argumentos);
    }

    @Test
    public void impresionProgresivaDeNumerosPares(){
        String argumentos[] = {"-o=pd","-n=p","8"};
        Program.main(argumentos);
    }

}
