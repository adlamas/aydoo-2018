package ar.edu.untref.aydoo;

public class ArtLibreria extends Producto {

    private int IVA;

    public ArtLibreria(int precio, int IVA){
        super(precio);
        this.IVA = IVA;
    }

    public int getIVA() {
        return IVA;
    }
}
