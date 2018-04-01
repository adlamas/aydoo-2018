package ar.edu.untref.aydoo;

public class HacedorDeCafe {

    private Cafetero Cafetero = new Cafetero();
    private Lechero Lechero = new Lechero();

    public Vaso hacerCafeConLeche(Vaso vaso){
        Lechero.ponerLeche(vaso);
        Cafetero.ponerCafe(vaso);

        return vaso;
    }
}
