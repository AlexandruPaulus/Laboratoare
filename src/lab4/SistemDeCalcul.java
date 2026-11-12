package lab4;

public class SistemDeCalcul extends Echipament{
    public enum TipMonitor{
        IPS,
        OLED,
        MINILED
    }
    public enum SistemOperare{
        WINDOWS,
        LINUX
    }
    private double vit_procesor;
    private int capacitate_SSD;
    private TipMonitor tipMonitor;
    private SistemOperare sistemOperare;

    public SistemDeCalcul(String denumire, int nr_inventar,Double pret, ZonaMag zonaMag, StareProdus stareProdus, double vit_procesor,int capacitate_SSD, TipMonitor tipMonitor,SistemOperare sistemOperare){
        super(denumire,nr_inventar,pret,zonaMag,stareProdus);
        this.vit_procesor = vit_procesor;
        this.capacitate_SSD = capacitate_SSD;
        this.tipMonitor = tipMonitor;
        this.sistemOperare = sistemOperare;
    }


    @Override
    public String toString(){
        return super.toString() + "\nviteza procesor:" + vit_procesor + ", capacitate stocare:" + capacitate_SSD + ", tip monitor:" + tipMonitor.toString() + ", Sistem de operare:" + sistemOperare.toString();
    }
}

