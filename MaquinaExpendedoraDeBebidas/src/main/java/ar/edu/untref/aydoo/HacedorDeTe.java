package ar.edu.untref.aydoo;

public class HacedorDeTe {

    private Tetero Tetero = new Tetero();
    private Lechero Lechero = new Lechero();

    public void hacerTeConLeche(Vaso vaso){
        Lechero.ponerLeche(vaso);
        Tetero.ponerTe(vaso);

        //return vaso;

    }
}
