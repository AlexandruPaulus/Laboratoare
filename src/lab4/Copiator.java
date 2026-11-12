package lab4;

public class Copiator extends Echipament {

    public enum FormatCopiere{
        A3,
        A4
    }
    private int nr_pg_toner;
    private FormatCopiere formatCopiere;

    public Copiator(String denumire, int nr_inventar,Double pret, ZonaMag zonaMag, StareProdus stareProdus, int nr_pg_toner, FormatCopiere formatCopiere){
        super(denumire,nr_inventar,pret,zonaMag,stareProdus);
        this.nr_pg_toner = nr_pg_toner;
        this.formatCopiere = formatCopiere;
    }

    @Override
    public String toString() {
        return super.toString() + "\npagini/toner:" + nr_pg_toner + ", format copiere:" + formatCopiere;
    }
}
