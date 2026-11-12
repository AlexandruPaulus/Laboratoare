package lab4;

public class Imprimanta extends Echipament {
    public enum ModTiparire{
        COLOR,
        ALB_NEGRU
    }
    private int nr_pg_pmin;
    private int rezolutie;
    private int nr_pg_cart;
    private ModTiparire modTiparire;

    public Imprimanta(String denumire, int nr_inventar, double pret, ZonaMag zonaMag, StareProdus stareProdus,int nr_pg_pmin, int rezolutie,int nr_pg_cart, ModTiparire modTiparire){
        super(denumire,nr_inventar,pret,zonaMag,stareProdus);
        this.nr_pg_pmin = nr_pg_pmin;
        this.rezolutie = rezolutie;
        this.nr_pg_cart = nr_pg_cart;
        this.modTiparire = modTiparire;
    }

    public void setModTiparire(String modTiparire){
        this.modTiparire = Imprimanta.ModTiparire.valueOf(modTiparire);
    }

    @Override
    public String toString(){
        return super.toString() + "\nnumar pagini/minut:" + nr_pg_pmin + ", rezolutie:" + rezolutie + ", numar pagini/cartus:" + nr_pg_cart + ", mod tiparire:" + modTiparire + "\n";
    }
}
