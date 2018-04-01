package ar.edu.untref.aydoo;

public class MaquinaExpendedoraDeBebidas {

    private HacedorDeCafe hacedorDeCafe = new HacedorDeCafe();
    private HacedorDeTe hacedorDeTe = new HacedorDeTe();
    private Azucarero azucarero = new Azucarero();

    public Vaso hacerCafeConLecheConNDeAzucar(Vaso unVaso, int cantidadAzucar){
        hacedorDeCafe.hacerCafeConLeche(unVaso);
        azucarero.ponerAzucar(unVaso, cantidadAzucar);

        return unVaso;
    }

    public void hacerTeConLecheConNDeAzucar(Vaso unVaso, int cantidadAzucar){

    }
}
